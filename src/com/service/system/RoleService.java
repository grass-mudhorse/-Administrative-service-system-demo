package com.service.system;

import java.util.List;

import com.core.common.BaseService;
import com.po.Role;
import com.vo.RoleVo;

public interface RoleService extends BaseService<Role, Integer>{
	/**
	 * 查询角色，含rid和frid
	 * @return
	 */
	public List<RoleVo> findRid();
	
	/**
	 * 根据职务id查询角色
	 * @param t
	 * @return
	 */
	public List<RoleVo> findRidByPositionid(RoleVo t);
	
	/**
	 * 分页查询角色
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Role> vagueFind(String contant,int currentpage,int pagesize);
	
	/**
	 * 根据员工id查询角色
	 * @param eid
	 * @return
	 */
	public Role findByEpId(Integer eid);
}
