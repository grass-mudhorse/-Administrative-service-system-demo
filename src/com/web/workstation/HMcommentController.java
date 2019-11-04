package com.web.workstation;

import java.util.List;
import net.sf.json.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.common.BaseController;
import com.po.Comment;
import com.service.workstation.HMcommentService;;

@Controller
@RequestMapping("/hmcommentController")
public class HMcommentController extends BaseController{
	
	@Autowired
	private HMcommentService hmcommentService;
	
	/**
	 * 车辆类别页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "/workstation/hmcomment/hmcomment_list";
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
		int sumrow = hmcommentService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<Comment> list = hmcommentService.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("hmcomments", list);
		return "/workstation/hmcomment/table/hmcommenttable";
	}
	
	/**
	 * 新增车辆类别页面
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(){
		return "/workstation/hmcomment/hmcomment_add";
	}
	
	/**
	 * 新增车辆类别
	 * @param vo
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Comment vo){
		vo.setIsvalid(1);
		hmcommentService.add(vo);
		List<Comment> list = hmcommentService.findAll();
		request().setAttribute("hmcomments", list);
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
		Comment vo = hmcommentService.findById(id);
		request().setAttribute("hmcomment", vo);
		return "/workstation/hmcomment/hmcomment_edit";
	}
	
	/**
	 * 修改车辆类别
	 * @param vo
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Comment vo){
		hmcommentService.edit(vo);
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
		int i = hmcommentService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}

	
	
}
