package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Requepara;
import com.lessismore.commont.service.RequeparaService;
import com.lessismore.commont.dao.RequeparaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequeparaServiceImpl extends BaseServiceImpl<Integer, Requepara> implements RequeparaService {
	
	@Autowired
	private RequeparaDao dao;

}