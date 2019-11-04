package com.service.workstation;


import java.util.List;


import com.core.common.BaseService;
import com.po.Comment;


public interface HMcommentService extends BaseService<Comment, Integer>{
	/**
	 * 分页查询车辆类别
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Comment> vagueFind(String contant,int currentpage,int pagesize);
}
