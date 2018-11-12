package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.TecCoope;
import com.lessismore.commont.service.TecCoopeService;
import com.lessismore.commont.dao.TecCoopeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecCoopeServiceImpl extends BaseServiceImpl<Integer, TecCoope> implements TecCoopeService {
	
	@Autowired
	private TecCoopeDao dao;

}