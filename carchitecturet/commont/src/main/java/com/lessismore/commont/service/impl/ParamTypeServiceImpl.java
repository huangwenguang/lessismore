package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.ParamType;
import com.lessismore.commont.service.ParamTypeService;
import com.lessismore.commont.dao.ParamTypeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamTypeServiceImpl extends BaseServiceImpl<Integer, ParamType> implements ParamTypeService {
	
	@Autowired
	private ParamTypeDao dao;

}