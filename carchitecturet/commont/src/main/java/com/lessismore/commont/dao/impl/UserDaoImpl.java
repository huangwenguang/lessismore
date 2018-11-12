package com.lessismore.commont.dao.impl;

import com.lessismore.commont.model.User;
import com.lessismore.commont.dao.UserDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Integer, User> implements UserDao {

}