package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.RequestType;
import com.lessismore.commont.service.RequestTypeService;
import com.lessismore.commont.dao.RequestTypeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestTypeServiceImpl extends BaseServiceImpl<Integer, RequestType> implements RequestTypeService {
	
	@Autowired
	private RequestTypeDao dao;

}