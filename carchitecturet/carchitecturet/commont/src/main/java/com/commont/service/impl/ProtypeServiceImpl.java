package com.commont.service.impl;



import com.commont.dao.ProtypeDao;
import com.commont.model.Protype;
import com.commont.service.ProtypeService;

import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtypeServiceImpl extends BaseServiceImpl<Integer, Protype> implements ProtypeService {
	
	@Autowired
	private ProtypeDao dao;	
}