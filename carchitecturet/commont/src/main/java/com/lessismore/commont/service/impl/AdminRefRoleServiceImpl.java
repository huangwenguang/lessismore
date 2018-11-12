package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.AdminRefRole;
import com.lessismore.commont.service.AdminRefRoleService;
import com.lessismore.commont.dao.AdminRefRoleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRefRoleServiceImpl extends BaseServiceImpl<Integer, AdminRefRole> implements AdminRefRoleService {
	
	@Autowired
	private AdminRefRoleDao dao;

}