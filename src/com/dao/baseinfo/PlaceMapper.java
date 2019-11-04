package com.dao.baseinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Place;

public interface PlaceMapper {
	/**
	 * 添加收费类别
	 * @param record
	 * @return
	 */
    int insert(Place record);
    
    /**
     * 查询收费类别
     * @return
     */
    List<Place> findAll();

    /**
     * 根据id查询收费类别
     * @param id
     * @return
     */
    Place selectByPrimaryKey(Integer id);
    
    /**
     * 修改车辆类别
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Place record);
    
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
    List<Place> vagueFind(@Param("contant")String contant,@Param("currentpage")Integer currentpage,@Param("pagesize")Integer pagesize);
}