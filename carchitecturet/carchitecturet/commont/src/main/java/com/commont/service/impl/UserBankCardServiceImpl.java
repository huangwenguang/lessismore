package com.commont.service.impl;

import com.commont.dao.UserBankCardDao;
import com.commont.model.UserBankCard;
import com.commont.service.UserBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBankCardServiceImpl extends BaseServiceImpl<Integer, UserBankCard> implements UserBankCardService {
	
	@Autowired
	private UserBankCardDao dao;

}