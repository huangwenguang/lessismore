package com.commont.service;


import com.commont.model.Admin;
import com.commont.util.JsonResult;

public interface AdminService extends BaseService<Integer, Admin> {
	JsonResult Login(String passport, String password)  throws Exception;
	
	JsonResult saveOrUpdate(Admin admin, Integer[] roleids);
}