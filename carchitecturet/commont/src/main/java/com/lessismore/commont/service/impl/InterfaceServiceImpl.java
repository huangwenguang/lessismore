package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Interface;
import com.lessismore.commont.service.InterfaceService;
import com.lessismore.commont.dao.InterfaceDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterfaceServiceImpl extends BaseServiceImpl<Integer, Interface> implements InterfaceService {
	
	@Autowired
	private InterfaceDao dao;

}