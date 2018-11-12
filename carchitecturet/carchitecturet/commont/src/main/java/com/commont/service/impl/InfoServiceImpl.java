package com.commont.service.impl;

import com.commont.dao.InfoDao;
import com.commont.model.Info;
import com.commont.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl extends BaseServiceImpl<Integer, Info> implements InfoService {
	
	@Autowired
	private InfoDao dao;

}