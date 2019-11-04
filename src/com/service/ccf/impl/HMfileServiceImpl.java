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

import com.dao.ccf.HMfileMapper;
import com.po.Filetable;
import com.service.ccf.HMfileService;

@Transactional
@Service("hmfileService")
public class HMfileServiceImpl implements HMfileService 
{
	@Autowired
	private HMfileMapper hmfiledao;
	
	@Override
	public List<Filetable> findAll() {
		return hmfiledao.findAll();
	}

	@Override
	public int add(Filetable t) {
		return hmfiledao.insert(t);
	}

	@Override
	public Filetable findById(int id) {
		return hmfiledao.selectByPrimaryKey(id);
	}
	

	@Override
	public int edit(Filetable t) {
		return hmfiledao.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return hmfiledao.delete(id);
	}

	@Override
	public List<Filetable> vagueFind(String contant, int currentpage,
			int pagesize) {
		return hmfiledao.vagueFind(contant, currentpage, pagesize);
	}
}