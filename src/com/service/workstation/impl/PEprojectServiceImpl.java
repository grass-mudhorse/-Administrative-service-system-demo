package com.service.workstation.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.workstation.PEprojectMapper;
import com.po.Project;
import com.service.workstation.PEprojectService;


@Transactional
@Service("PEprojectService")
public class PEprojectServiceImpl implements PEprojectService {

	@Autowired
	private PEprojectMapper ProjectMapper;
	
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
