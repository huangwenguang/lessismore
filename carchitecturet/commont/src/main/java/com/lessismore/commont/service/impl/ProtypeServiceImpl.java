package com.lessismore.commont.service.impl;



import com.lessismore.commont.model.Protype;
import com.lessismore.commont.service.ProtypeService;

import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.dao.ProtypeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtypeServiceImpl extends BaseServiceImpl<Integer, Protype> implements ProtypeService {
	
	@Autowired
	private ProtypeDao dao;	
}