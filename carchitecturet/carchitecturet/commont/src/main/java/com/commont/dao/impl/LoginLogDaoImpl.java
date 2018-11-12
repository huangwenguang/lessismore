package com.commont.dao.impl;

import com.commont.dao.LoginLogDao;
import com.commont.model.LoginLog;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDaoImpl extends BaseDaoImpl<Integer, LoginLog> implements LoginLogDao {

}