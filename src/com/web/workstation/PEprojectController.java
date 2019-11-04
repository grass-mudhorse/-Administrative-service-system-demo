package com.web.workstation;

import java.util.List;
import net.sf.json.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.common.BaseController;
import com.po.Project;
import com.service.workstation.PEprojectService;;

@Controller
@RequestMapping("/peprojectController")
public class PEprojectController extends BaseController{
	
	@Autowired
	private PEprojectService peprojectService;
	
	
	@RequestMapping("/list")
	public String list(){
		return "/workstation/peproject/peproject_list";
	}
	
	
	@RequestMapping("/datalist")
	public String datalist(String contant,int pagesize, int currentpage){
		//获取总行数
		int sumrow = peprojectService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Project> list = peprojectService.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("peprojects", list);
		return "/workstation/peproject/table/peprojecttable";
	}
	
	
	@RequestMapping("/toadd")
	public String toadd(){
		return "/workstation/peproject/peproject_add";
	}
	
	
	@RequestMapping("/add")
	public String add(Project vo){
		vo.setIsvalid(1);
		peprojectService.add(vo);
		List<Project> list = peprojectService.findAll();
		request().setAttribute("peprojects", list);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Project vo = peprojectService.findById(id);
		request().setAttribute("peproject", vo);
		return "/workstation/peproject/peproject_edit";
	}
	
	
	@RequestMapping("/edit")
	public String edit(Project vo){
		peprojectService.edit(vo);
		request().setAttribute("resulttext", "edit");
		return list();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = peprojectService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}

	
	
}
