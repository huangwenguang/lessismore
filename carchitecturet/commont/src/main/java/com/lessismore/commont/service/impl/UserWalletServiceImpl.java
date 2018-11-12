package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.UserWallet;
import com.lessismore.commont.service.UserWalletService;
import com.lessismore.commont.dao.UserWalletDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl extends BaseServiceImpl<Integer, UserWallet> implements UserWalletService {
	
	@Autowired
	private UserWalletDao dao;

}