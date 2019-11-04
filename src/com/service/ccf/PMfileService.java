/**
 * 
 */
/**
 * @author 澈暝
 *
 */
package com.service.ccf;

import java.util.List;


import com.core.common.BaseService;
import com.po.Filetable;


public interface PMfileService extends BaseService<Filetable, Integer>  
{
	public List<Filetable> vagueFind(String contant,int currentpage,int pagesize);
}

