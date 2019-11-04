/**
 * 
 */
/**
 * @author 澈暝
 *
 */
package com.service.ccf.impl;
import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import java.io.File;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ccf.PMfileMapper;
import com.po.Filetable;
import com.service.ccf.PMfileService;

@Transactional
@Service("pmfileService")
public class PMfileServiceImpl implements PMfileService 
{
	@Autowired
	private PMfileMapper pmfiledao;
	
	@Override
	public List<Filetable> findAll() {
		return pmfiledao.findAll();
	}

	@Override
	public int add(Filetable t) {
		return pmfiledao.insert(t);
	}

	@Override
	public Filetable findById(int id) {
		return pmfiledao.selectByPrimaryKey(id);
	}
	

	@Override
	public int edit(Filetable t) {
		return pmfiledao.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return pmfiledao.delete(id);
	}

	@Override
	public List<Filetable> vagueFind(String contant, int currentpage,
			int pagesize) {
		return pmfiledao.vagueFind(contant, currentpage, pagesize);
	}
}