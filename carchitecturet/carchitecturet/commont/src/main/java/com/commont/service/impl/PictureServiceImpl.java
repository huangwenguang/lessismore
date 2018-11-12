package com.commont.service.impl;

import com.commont.dao.PictureDao;
import com.commont.model.Picture;
import com.commont.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl extends BaseServiceImpl<Integer, Picture> implements PictureService {
	
	@Autowired
	private PictureDao dao;

}