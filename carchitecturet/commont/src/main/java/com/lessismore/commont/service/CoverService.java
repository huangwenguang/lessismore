package com.lessismore.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Cover;
import com.lessismore.commont.util.JsonResult;

public interface CoverService extends BaseService<Integer, Cover> {
	public JsonResult saveDo(Cover cover,MultipartFile file);
}