package com.commont.service;


import com.commont.model.Role;
import com.commont.util.JsonResult;

public interface RoleService extends BaseService<Integer, Role> {
	JsonResult saveOrUpdate(Role role);
}