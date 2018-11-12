package com.commont.service.impl;

import com.commont.dao.LoginLogDao;
import com.commont.model.LoginLog;
import com.commont.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends BaseServiceImpl<Integer, LoginLog> implements LoginLogService {
	
	@Autowired
	private LoginLogDao dao;

}