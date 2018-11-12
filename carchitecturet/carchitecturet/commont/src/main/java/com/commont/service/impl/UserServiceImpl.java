package com.commont.service.impl;

import com.commont.dao.UserDao;
import com.commont.model.User;
import com.commont.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<Integer, User> implements UserService {
	
	@Autowired
	private UserDao dao;

}