package com.lessismore.commont.service;

import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.util.JsonResult;




public interface GwUserService extends BaseService<Integer, GwUser> {
//保存用户
JsonResult saveOrUpdate(GwUser gwUser);

}