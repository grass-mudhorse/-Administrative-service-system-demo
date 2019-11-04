package com.service.baseinfo.impl;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.core.util.ExcelBean;
import com.core.util.ExcelUtil;
import com.dao.baseinfo.RestaurantMapper;
import com.po.Restaurant;
import com.service.baseinfo.RestaurantService;

@Transactional
@Service("RestaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantMapper RestaurantMapper;
	
	@Override
	public List<Restaurant> findAll() {
		return RestaurantMapper.findAll();
	}

	@Override
	public int add(Restaurant t) {
		return RestaurantMapper.insert(t);
	}

	@Override
	public Restaurant findById(int id) {
		return RestaurantMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Restaurant t) {
		return RestaurantMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return RestaurantMapper.delete(id);
	}

	@Override
	public List<Restaurant> vagueFind(String contant, int currentpage,
			int pagesize) {
		return RestaurantMapper.vagueFind(contant, currentpage, pagesize);
	}
	
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listobs = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listobs.size(); i++) {
	    	List<Object> listob = listobs.get(i);
	        Restaurant vo = new Restaurant();
	        Restaurant j= null;	        
	        try {
				j = RestaurantMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(listob.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch blistobck
				System.out.println("没有新增");
			}
			    vo.setId(Integer.valueOf(String.valueOf(listob.get(0))));  
	            vo.setRestaurantname(String.valueOf(listob.get(1)));  
	            vo.setRestaurantsize(Integer.valueOf(String.valueOf(listob.get(2))));
	            vo.setRestaurantnum(Integer.valueOf(String.valueOf(listob.get(3))));
	            vo.setRestaurantloc(String.valueOf(listob.get(4)));	            
	            vo.setRestaurantpri(Integer.valueOf(String.valueOf(listob.get(5))));
	            vo.setRestaurantcon(String.valueOf(listob.get(6)));
	            vo.setRestauranttempcon(String.valueOf(listob.get(7)));	            
	            vo.setIsvalid(Integer.valueOf(String.valueOf(listob.get(8))));
			if(j == null)
			{
		            RestaurantMapper.insert(vo);
			}
			else
			{
		            RestaurantMapper.updateByPrimaryKeySelective(vo);
			}
        }   

	}
	
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
	    //根据条件查询数据，把数据装载到一个list中
	    List<Restaurant> list = RestaurantMapper.findAll();

	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("序号","id",0));
	    excel.add(new ExcelBean("餐厅名称","restaurantname",0));
	    excel.add(new ExcelBean("餐厅可选规模种类","restaurantsize",0));
	    excel.add(new ExcelBean("餐厅可选规模个数","restaurantnum",0));
	    excel.add(new ExcelBean("餐厅位置","restaurantloc",0));
	    excel.add(new ExcelBean("餐厅价格","restaurantpri",0));
	    excel.add(new ExcelBean("餐厅租用情况","restaurantcon",0));
	    excel.add(new ExcelBean("餐厅情况","restauranttempcon",0));
	    excel.add(new ExcelBean("餐厅是否有效","isvalid",0));
	    map.put(0, excel);
	    String sheetName = "Date";
	    //调用ExcelUtil的方法
	    xssfWorkbook = ExcelUtil.createExcelFile(Restaurant.class, list, map, sheetName);
	    return xssfWorkbook;
	}
	

}
