package com.service.workstation.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.workstation.ClientcommentMapper;
import com.po.Comment;
import com.service.workstation.ClientcommentService;


@Transactional
@Service("ClientcommentService")
public class ClientcommentServiceImpl implements ClientcommentService {

	@Autowired
	private ClientcommentMapper CommentMapper;
	
	@Override
	public List<Comment> findAll() {
		return CommentMapper.findAll();
	}

	@Override
	public int add(Comment t) {
		return CommentMapper.insert(t);
	}

	@Override
	public Comment findById(int id) {
		return CommentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Comment t) {
		return CommentMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return CommentMapper.delete(id);
	}

	@Override
	public List<Comment> vagueFind(String contant, int currentpage,
			int pagesize) {
		return CommentMapper.vagueFind(contant, currentpage, pagesize);
	}
	
}
