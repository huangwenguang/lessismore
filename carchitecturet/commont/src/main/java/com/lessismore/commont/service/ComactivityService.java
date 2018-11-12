package com.lessismore.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Comactivity;
import com.lessismore.commont.util.JsonResult;

public interface ComactivityService extends BaseService<Integer, Comactivity> {
	public JsonResult saveDo(Comactivity comactivity,MultipartFile file);
}