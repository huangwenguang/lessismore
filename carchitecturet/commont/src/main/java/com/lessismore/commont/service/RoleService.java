package com.lessismore.commont.service;


import com.lessismore.commont.model.Role;
import com.lessismore.commont.util.JsonResult;

public interface RoleService extends BaseService<Integer, Role> {
	JsonResult saveOrUpdate(Role role);
}