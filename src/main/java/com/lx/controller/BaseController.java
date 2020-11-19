package com.lx.controller;

import com.lx.error.BusinessException;
import com.lx.error.EmBusinessError;
import com.lx.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BaseController
 * @Description:
 * @author: SeanLeong
 * @date: 2020/11/17 21:03
 */
public class BaseController {
    //SpringBoot定义 exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)  //设置处理的异常类型
    @ResponseStatus(HttpStatus.OK)  //响应的状态
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String, Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrorCode());
            responseData.put("errMsg", businessException.getErrorMsg());
        }else{
            responseData.put("errCode", EmBusinessError.UNKNOW_ERROR.getErrorCode());
            responseData.put("errMsg", EmBusinessError.UNKNOW_ERROR.getErrorMsg());
        }


        return CommonReturnType.create(responseData, "fail");
    }
}
