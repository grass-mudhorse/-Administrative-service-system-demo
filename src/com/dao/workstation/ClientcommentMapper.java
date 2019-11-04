package com.dao.workstation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Comment;

public interface ClientcommentMapper {
	/**
	 * 添加收费类别
	 * @param record
	 * @return
	 */
    int insert(Comment record);
    
    /**
     * 查询收费类别
     * @return
     */
    List<Comment> findAll();

    /**
     * 根据id查询收费类别
     * @param id
     * @return
     */
    Comment selectByPrimaryKey(Integer id);
    
    /**
     * 修改车辆类别
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Comment record);
    
    /**
     * 删除收费类别
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 分页模糊查询收费类别
     * @param contant
     * @param currentpage
     * @param pagesize
     * @return
     */
    List<Comment> vagueFind(@Param("contant")String contant,@Param("currentpage")Integer currentpage,@Param("pagesize")Integer pagesize);
    

}