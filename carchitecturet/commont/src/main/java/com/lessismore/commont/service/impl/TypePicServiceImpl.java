package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.TypePic;
import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.dao.TypePicDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePicServiceImpl extends BaseServiceImpl<Integer, TypePic> implements TypePicService {
	
	@Autowired
	private TypePicDao dao;

}