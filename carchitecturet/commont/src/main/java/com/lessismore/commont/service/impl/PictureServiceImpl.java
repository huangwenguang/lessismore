package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Picture;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.dao.PictureDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl extends BaseServiceImpl<Integer, Picture> implements PictureService {
	
	@Autowired
	private PictureDao dao;

}