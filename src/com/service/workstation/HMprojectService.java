package com.service.workstation;


import java.util.List;


import com.core.common.BaseService;
import com.po.Project;


public interface HMprojectService extends BaseService<Project, Integer>{
	/**
	 * 分页查询车辆类别
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Project> vagueFind(String contant,int currentpage,int pagesize);
}
