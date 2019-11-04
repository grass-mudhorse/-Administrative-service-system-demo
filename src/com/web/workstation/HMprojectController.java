package com.web.workstation;

import java.util.List;
import net.sf.json.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.common.BaseController;
import com.po.Project;
import com.service.workstation.HMprojectService;;

@Controller
@RequestMapping("/hmprojectController")
public class HMprojectController extends BaseController{
	
	@Autowired
	private HMprojectService hmprojectService;
	
	
	@RequestMapping("/list")
	public String list(){
		return "/workstation/hmproject/hmproject_list";
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
		int sumrow = hmprojectService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Project> list = hmprojectService.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("hmprojects", list);
		return "/workstation/hmproject/table/hmprojecttable";
	}
	
	
	@RequestMapping("/toadd")
	public String toadd(){
		return "/workstation/hmproject/hmproject_add";
	}
	
	@RequestMapping("/add")
	public String add(Project vo){
		vo.setIsvalid(1);
		hmprojectService.add(vo);
		List<Project> list = hmprojectService.findAll();
		request().setAttribute("hmprojects", list);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Project vo = hmprojectService.findById(id);
		request().setAttribute("hmproject", vo);
		return "/workstation/hmproject/hmproject_edit";
	}
	
	/**
	 * 修改车辆类别
	 * @param vo
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Project vo){
		hmprojectService.edit(vo);
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
		int i = hmprojectService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}

	
	
}
