package com.commont.dao.impl;

import com.commont.dao.UserDao;
import com.commont.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Integer, User> implements UserDao {

}