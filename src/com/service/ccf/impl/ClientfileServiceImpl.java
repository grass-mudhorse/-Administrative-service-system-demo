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

import com.dao.ccf.ClientfileMapper;
import com.po.Filetable;
import com.service.ccf.ClientfileService;

@Transactional
@Service("clientfileService")
public class ClientfileServiceImpl implements ClientfileService 
{
	@Autowired
	private ClientfileMapper clientfiledao;
	
	@Override
	public List<Filetable> findAll() {
		return clientfiledao.findAll();
	}

	@Override
	public int add(Filetable t) {
		return clientfiledao.insert(t);
	}

	@Override
	public Filetable findById(int id) {
		return clientfiledao.selectByPrimaryKey(id);
	}
	

	@Override
	public int edit(Filetable t) {
		return clientfiledao.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return clientfiledao.delete(id);
	}

	@Override
	public List<Filetable> vagueFind(String contant, int currentpage,
			int pagesize) {
		return clientfiledao.vagueFind(contant, currentpage, pagesize);
	}
}