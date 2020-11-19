package com.lx.controller;

import com.alibaba.druid.util.Base64;
import com.lx.controller.viewobject.UserVO;
import com.lx.error.BusinessException;
import com.lx.error.EmBusinessError;
import com.lx.response.CommonReturnType;
import com.lx.services.UserService;
import com.lx.services.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Description:
 * @author: SeanLeong
 * @date: 2020/11/17 11:07
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        if(userModel == null){
            //知道错误类型，给Exception进行包装，抛出，给Base进行处理
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        return CommonReturnType.create(this.convertFromModel(userModel));
    }

    private UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}
