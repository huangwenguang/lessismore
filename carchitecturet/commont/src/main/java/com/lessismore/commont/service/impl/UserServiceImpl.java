package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.User;
import com.lessismore.commont.service.UserService;
import com.lessismore.commont.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<Integer, User> implements UserService {
	
	@Autowired
	private UserDao dao;

}