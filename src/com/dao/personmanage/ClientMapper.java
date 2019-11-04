package com.dao.personmanage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Client;

public interface ClientMapper {
	/**
	 * 添加收费类别
	 * @param record
	 * @return
	 */
    int insert(Client record);
    
    /**
     * 查询收费类别
     * @return
     */
    List<Client> findAll();

    /**
     * 根据id查询收费类别
     * @param id
     * @return
     */
    Client selectByPrimaryKey(Integer id);
    
    /**
     * 修改车辆类别
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Client record);
    
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
    List<Client> vagueFind(@Param("contant")String contant,@Param("currentpage")Integer currentpage,@Param("pagesize")Integer pagesize);
}