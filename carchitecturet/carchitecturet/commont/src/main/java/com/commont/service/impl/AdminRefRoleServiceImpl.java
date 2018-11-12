package com.commont.service.impl;

import com.commont.dao.AdminRefRoleDao;
import com.commont.model.AdminRefRole;
import com.commont.service.AdminRefRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRefRoleServiceImpl extends BaseServiceImpl<Integer, AdminRefRole> implements AdminRefRoleService {
	
	@Autowired
	private AdminRefRoleDao dao;

}