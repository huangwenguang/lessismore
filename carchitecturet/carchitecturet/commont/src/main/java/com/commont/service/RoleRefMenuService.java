package com.commont.service;

import com.commont.model.RoleRefMenu;
import com.commont.util.JsonResult;

public interface RoleRefMenuService extends BaseService<Integer, RoleRefMenu> {
	JsonResult saveRoleMenuByMgt(Integer[] menuIds, Integer roleId);
}