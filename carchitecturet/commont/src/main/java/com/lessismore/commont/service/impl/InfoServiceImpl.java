package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Info;
import com.lessismore.commont.service.InfoService;
import com.lessismore.commont.dao.InfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl extends BaseServiceImpl<Integer, Info> implements InfoService {
	
	@Autowired
	private InfoDao dao;

}