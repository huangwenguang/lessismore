package com.lessismore.interfaces.controller;

import java.io.IOException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commont.util.CustomException;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;



@ControllerAdvice
public class RestExceptionHandler {



    //自定义异常
    @ExceptionHandler(CustomException.class)  
    @ResponseBody  
    public JsonResult CustomExceptionHandler(ErrorCode errorCode) {  
        return new JsonResult(errorCode);
    } 
    
   
}
