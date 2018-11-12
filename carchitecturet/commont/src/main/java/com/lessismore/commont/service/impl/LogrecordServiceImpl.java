package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Logrecord;
import com.lessismore.commont.service.LogrecordService;
import com.lessismore.commont.dao.LogrecordDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogrecordServiceImpl extends BaseServiceImpl<Integer, Logrecord> implements LogrecordService {
	
	@Autowired
	private LogrecordDao dao;

}