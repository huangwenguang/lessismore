package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.LoginLog;
import com.lessismore.commont.service.LoginLogService;
import com.lessismore.commont.dao.LoginLogDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends BaseServiceImpl<Integer, LoginLog> implements LoginLogService {
	
	@Autowired
	private LoginLogDao dao;

}