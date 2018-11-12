package com.lessismore.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Indexpro;
import com.lessismore.commont.util.JsonResult;

public interface IndexproService extends BaseService<Integer, Indexpro> {
	public JsonResult saveDo(Indexpro indexpro,MultipartFile file);
}