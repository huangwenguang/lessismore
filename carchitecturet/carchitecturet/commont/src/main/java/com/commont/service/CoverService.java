package com.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.commont.model.Cover;
import com.commont.util.JsonResult;

public interface CoverService extends BaseService<Integer, Cover> {
	public JsonResult saveDo(Cover cover,MultipartFile file);
}