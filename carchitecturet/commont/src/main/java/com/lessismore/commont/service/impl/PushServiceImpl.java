package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Push;
import com.lessismore.commont.service.PushService;
import com.lessismore.commont.dao.PushDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushServiceImpl extends BaseServiceImpl<Integer, Push> implements PushService {
	
	@Autowired
	private PushDao dao;

}