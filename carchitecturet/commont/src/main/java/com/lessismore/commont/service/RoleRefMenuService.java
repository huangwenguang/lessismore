package com.lessismore.commont.service;

import com.lessismore.commont.model.RoleRefMenu;
import com.lessismore.commont.util.JsonResult;

public interface RoleRefMenuService extends BaseService<Integer, RoleRefMenu> {
	JsonResult saveRoleMenuByMgt(Integer[] menuIds, Integer roleId);
}