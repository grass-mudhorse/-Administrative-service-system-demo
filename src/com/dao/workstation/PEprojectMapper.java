package com.dao.workstation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Project;

public interface PEprojectMapper {
	
    int insert(Project record);
    
   
    List<Project> findAll();

    Project selectByPrimaryKey(Integer id);
    
    
    int updateByPrimaryKeySelective(Project record);
   
    int delete(Integer id);
    
  
    List<Project> vagueFind(@Param("contant")String contant,@Param("currentpage")Integer currentpage,@Param("pagesize")Integer pagesize);
    

}