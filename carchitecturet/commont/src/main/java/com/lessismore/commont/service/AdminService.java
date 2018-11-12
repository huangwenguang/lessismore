package com.lessismore.commont.service;


import com.lessismore.commont.model.Admin;
import com.lessismore.commont.util.JsonResult;

public interface AdminService extends BaseService<Integer, Admin> {
	JsonResult Login(String passport, String password)  throws Exception;
	
	JsonResult saveOrUpdate(Admin admin, Integer[] roleids,String newUserPwd);
}