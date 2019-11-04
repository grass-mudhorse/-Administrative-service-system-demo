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



import com.core.util.DateUtil;
import com.core.util.FileLoadUtil;
import com.core.util.MD5Util;

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
import com.service.ccf.ClientfileService;
import com.core.common.BaseController;

import java.util.HashMap;
import java.util.Map;
import java.net.URLEncoder;

@Controller
@RequestMapping("/clientfileController")
public class ClientfileController extends BaseController{
	@Autowired
	private ClientfileService clientfileservice;


	@RequestMapping("/list")
	public String list(){
		return "/ccf/clientfile/clientfile_list";
	}
	
	@RequestMapping("/datalist")
	public String datalist(String contant,int pagesize, int currentpage){
		//获取总行数
		int sumrow = clientfileservice.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Filetable> list = clientfileservice.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("clientfiles", list);
		return "/ccf/clientfile/table/clientfile";
	}
	
	@RequestMapping("/toadd")
	public String toadd(){
		return "/ccf/clientfile/clientfile_add";
	}
	
	@RequestMapping("/add")
	public String add(Filetable vo ,@RequestParam(value="file",required=true)MultipartFile myfile) throws IOException{
		vo.setIsvalid(1);
		vo.setCategory("项目需求");
		String url = FileLoadUtil.file_load(myfile,request());
		if(url != ""){
			vo.setUrl(url);
		}else{
			System.out.printf("error");
		}
		
		
		clientfileservice.add(vo);
		List<Filetable> list = clientfileservice.findAll();
		request().setAttribute("clientfiles", list);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Filetable vo = clientfileservice.findById(id);
		request().setAttribute("clientfile", vo);
		return "/ccf/clientfile/clientfile_edit";
	}
	
	@RequestMapping("/todownload")
	public String todownload(Integer id){
		Filetable vo = clientfileservice.findById(id);
		request().setAttribute("clientfile", vo);
		return "/ccf/clientfile/clientfile_download";
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
		
        return "/ccf/clientfile/clientfile_list";
	}
	@RequestMapping("/edit")
	public String edit(Filetable vo){
		clientfileservice.edit(vo);
		request().setAttribute("resulttext", "edit");
		return list();
	}
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = clientfileservice.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
	
}