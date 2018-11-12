package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Returnpara;
import com.lessismore.commont.service.ReturnparaService;
import com.lessismore.commont.dao.ReturnparaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnparaServiceImpl extends BaseServiceImpl<Integer, Returnpara> implements ReturnparaService {
	
	@Autowired
	private ReturnparaDao dao;

}