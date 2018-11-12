package com.commont.service.impl;

import com.commont.dao.UserWalletDao;
import com.commont.model.UserWallet;
import com.commont.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl extends BaseServiceImpl<Integer, UserWallet> implements UserWalletService {
	
	@Autowired
	private UserWalletDao dao;

}