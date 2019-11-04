/**
 * 
 */
/**
 * @author 澈暝
 *
 */
package com.dao.ccf;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Filetable;

 
public interface HMfileMapper{

	int insert(Filetable record);
	List<Filetable> findAll();
	Filetable selectByPrimaryKey(Integer id);
	Filetable selectByKey(Integer createrid);
	int updateByPrimaryKeySelective(Filetable record);
	int delete(Integer id);
	List<Filetable> vagueFind(@Param("contant")String contant,@Param("currentpage")Integer currentpage,@Param("pagesize")Integer pagesize);
}