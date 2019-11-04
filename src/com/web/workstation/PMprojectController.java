package com.web.workstation;

import java.util.List;
import net.sf.json.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.common.BaseController;
import com.po.Project;
import com.service.workstation.PMprojectService;;

@Controller
@RequestMapping("/pmprojectController")
public class PMprojectController extends BaseController{
	
	@Autowired
	private PMprojectService pmprojectService;
	
	
	@RequestMapping("/list")
	public String list(){
		return "/workstation/pmproject/pmproject_list";
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
		int sumrow = pmprojectService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Project> list = pmprojectService.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("pmprojects", list);
		return "/workstation/pmproject/table/pmprojecttable";
	}
	
	
	@RequestMapping("/toadd")
	public String toadd(){
		return "/workstation/pmproject/pmproject_add";
	}
	
	
	@RequestMapping("/add")
	public String add(Project vo){
		vo.setIsvalid(1);
		pmprojectService.add(vo);
		List<Project> list = pmprojectService.findAll();
		request().setAttribute("pmprojects", list);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Project vo = pmprojectService.findById(id);
		request().setAttribute("pmproject", vo);
		return "/workstation/pmproject/pmproject_edit";
	}
	
	@RequestMapping("/edit")
	public String edit(Project vo){
		pmprojectService.edit(vo);
		request().setAttribute("resulttext", "edit");
		return list();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = pmprojectService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}

	
	
}
