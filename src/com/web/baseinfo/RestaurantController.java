package com.web.baseinfo;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.core.common.BaseController;
import com.po.Restaurant;
import com.service.baseinfo.RestaurantService;

@Controller
@RequestMapping("/restaurantController")
public class RestaurantController extends BaseController{
	
	@Autowired
	private RestaurantService restaurantService;
	
	/**
	 * 车辆类别页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "/baseinfo/restaurant/restaurant_list";
	}
	
	/**
	 * 分页模糊查询
	 * @param contant
	 * @param pagesize
	 * @param currentpage
	 * @return
	 */
	@RequestMapping("/datalist")
	public String datalist(String contant,int pagesize, int currentpage){
		//获取总行数
		int sumrow = restaurantService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Restaurant> list = restaurantService.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("restaurants", list);
		return "/baseinfo/restaurant/table/restauranttable";
	}
	
	/**
	 * 新增车辆类别页面
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(){
		return "/baseinfo/restaurant/restaurant_add";
	}
	
	/**
	 * 新增车辆类别
	 * @param vo
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Restaurant vo){
		vo.setIsvalid(1);
		restaurantService.add(vo);
		List<Restaurant> list = restaurantService.findAll();
		request().setAttribute("restaurants", list);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	/**
	 * 修改车辆类别页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Restaurant vo = restaurantService.findById(id);
		request().setAttribute("restaurant", vo);
		return "/baseinfo/restaurant/restaurant_edit";
	}
	
	/**
	 * 修改车辆类别
	 * @param vo
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Restaurant vo){
		restaurantService.edit(vo);
		request().setAttribute("resulttext", "edit");
		return list();
	}
	
	/**
	 * 删除车辆类别
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = restaurantService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}

	@RequestMapping("/export")
	public void export (HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException{
	    String Date = "2018/12/18.xlsx";
	    if(Date!=""){
	        response.reset(); //清除buffer缓存
	        Map<String,Object> map=new HashMap<String,Object>();
	        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
	        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
	        response.setHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis()+".xlsx");
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	        XSSFWorkbook workbook=null;
	        //导出Excel对象
	        workbook = restaurantService.exportExcelInfo();
	        OutputStream output;
	        try {
	            output = response.getOutputStream();
	            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
	            bufferedOutPut.flush();
	            workbook.write(bufferedOutPut);
	            bufferedOutPut.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
		
	}
	
	
	@RequestMapping(value="/impotr",method=RequestMethod.POST)
	public String impotr(HttpServletRequest request, Model model) throws Exception {
	     //获取上传的文件
	     MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
	     MultipartFile file = multipart.getFile("upfile");
	     InputStream in = file.getInputStream();
	     //数据导入
	     restaurantService.importExcelInfo(in,file);
	     in.close();
	     return "/baseinfo/restaurant/restaurant_list";
	}
	
	
}
