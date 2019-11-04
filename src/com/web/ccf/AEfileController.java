/**
 * 
 */
/**
 * @author 澈暝
 *
 */
package com.web.ccf;
import java.io.File;
import javax.annotation.Resource;

import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletOutputStream;


import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;

import net.sf.json.JSONSerializer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.po.Filetable;
import com.service.ccf.AEfileService;
import com.core.common.BaseController;
import com.core.util.FileLoadUtil;

import java.util.HashMap;
import java.util.Map;
import java.net.URLEncoder;

@Controller
@RequestMapping("/aefileController")
public class AEfileController extends BaseController{
	@Autowired
	private AEfileService aefileservice;


	@RequestMapping("/list")
	public String list(){
		return "/ccf/aefile/aefile_list";
	}
	
	@RequestMapping("/datalist")
	public String datalist(String contant,int pagesize, int currentpage){
		//获取总行数
		int sumrow = aefileservice.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Filetable> list = aefileservice.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("aefiles", list);
		return "/ccf/aefile/table/aefile";
	}
	
	@RequestMapping("/toadd")
	public String toadd(){
		return "/ccf/aefile/aefile_add";
	}
	
	@RequestMapping("/add")
	public String add(Filetable vo,@RequestParam(value="file",required=true)MultipartFile myfile)throws IOException{
		vo.setIsvalid(1);
		vo.setCategory("项目意向书");
		String url = FileLoadUtil.file_load(myfile,request());
		if(url != ""){
			vo.setUrl(url);
		}else{
			System.out.printf("error");
		}
		aefileservice.add(vo);
		List<Filetable> list = aefileservice.findAll();
		request().setAttribute("aefiles", list);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Filetable vo = aefileservice.findById(id);
		request().setAttribute("aefile", vo);
		return "/ccf/aefile/aefile_edit";
	}
	
	@RequestMapping("/todownload")
	public String todownload(Integer id){
		Filetable vo = aefileservice.findById(id);
		request().setAttribute("aefile", vo);
		return "/ccf/aefile/aefile_download";
	}
	
	@RequestMapping("/download")
	public String download(Filetable f,HttpServletRequest request,HttpServletResponse response)throws Exception
	{
      
		
		String path="D:\\upload\\"+f.getUrl();
		InputStream bis=new BufferedInputStream(new FileInputStream(new File(path)));
		String filename="下载文件.doc";
		filename=URLEncoder.encode(filename,"UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);  
		response.setContentType("multipart/form-data"); 
		 BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		 int len = 0;

	        while((len = bis.read()) != -1){

	            out.write(len);

	            out.flush();

	        }

	        out.close();
		
        return "/ccf/aefile/aefile_list";
	}
	@RequestMapping("/edit")
	public String edit(Filetable vo){
		aefileservice.edit(vo);
		request().setAttribute("resulttext", "edit");
		return list();
	}
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = aefileservice.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
	
}