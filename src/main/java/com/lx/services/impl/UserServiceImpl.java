package com.lx.services.impl;

import com.lx.dataObject.UserDO;
import com.lx.dataObject.UserPasswordDO;
import com.lx.dao.UserDOMapper;
import com.lx.dao.UserPasswordDOMapper;
import com.lx.services.UserService;
import com.lx.services.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @author: SeanLeong
 * @date: 2020/11/17 11:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //调用userDOMapper获取对应的用户UserDO
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if(userDO == null){
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO, userPasswordDO);
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
        if(userDO == null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if(userPasswordDO != null) {
            userModel.setEncrptPassword(userPasswordDO.getEncrpyPassword());
        }
        return userModel;
    }
}
