package com.service.workstation.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.workstation.HMprojectMapper;
import com.po.Project;
import com.service.workstation.HMprojectService;


@Transactional
@Service("HMprojectService")
public class HMprojectServiceImpl implements HMprojectService {

	@Autowired
	private HMprojectMapper ProjectMapper;
	
	@Override
	public List<Project> findAll() {
		return ProjectMapper.findAll();
	}

	@Override
	public int add(Project t) {
		return ProjectMapper.insert(t);
	}

	@Override
	public Project findById(int id) {
		return ProjectMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Project t) {
		return ProjectMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return ProjectMapper.delete(id);
	}

	@Override
	public List<Project> vagueFind(String contant, int currentpage,
			int pagesize) {
		return ProjectMapper.vagueFind(contant, currentpage, pagesize);
	}
	
}
