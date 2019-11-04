package com.dao.baseinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Car;

public interface CarMapper {
	/**
	 * 添加收费类别
	 * @param record
	 * @return
	 */
    int insert(Car record);
    
    /**
     * 查询收费类别
     * @return
     */
    List<Car> findAll();

    /**
     * 根据id查询收费类别
     * @param id
     * @return
     */
    Car selectByPrimaryKey(Integer id);
    
    /**
     * 修改车辆类别
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Car record);
    
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
    List<Car> vagueFind(@Param("contant")String contant,@Param("currentpage")Integer currentpage,@Param("pagesize")Integer pagesize);
    

}