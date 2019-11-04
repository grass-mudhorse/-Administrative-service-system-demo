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

import com.dao.ccf.AEfileMapper;
import com.po.Filetable;
import com.service.ccf.AEfileService;

@Transactional
@Service("aefileService")
public class AEfileServiceImpl implements AEfileService 
{
	@Autowired
	private AEfileMapper aefiledao;
	
	@Override
	public List<Filetable> findAll() {
		return aefiledao.findAll();
	}

	@Override
	public int add(Filetable t) {
		return aefiledao.insert(t);
	}

	@Override
	public Filetable findById(int id) {
		return aefiledao.selectByPrimaryKey(id);
	}
	

	@Override
	public int edit(Filetable t) {
		return aefiledao.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return aefiledao.delete(id);
	}

	@Override
	public List<Filetable> vagueFind(String contant, int currentpage,
			int pagesize) {
		return aefiledao.vagueFind(contant, currentpage, pagesize);
	}
}