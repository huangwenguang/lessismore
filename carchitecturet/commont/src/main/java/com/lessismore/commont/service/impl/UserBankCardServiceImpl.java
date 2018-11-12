package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.UserBankCard;
import com.lessismore.commont.service.UserBankCardService;
import com.lessismore.commont.dao.UserBankCardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBankCardServiceImpl extends BaseServiceImpl<Integer, UserBankCard> implements UserBankCardService {
	
	@Autowired
	private UserBankCardDao dao;

}