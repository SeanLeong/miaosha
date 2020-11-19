package com.lx.services;

import com.lx.services.model.UserModel;

/**
 * @ClassName: UserService
 * @Description:
 * @author: SeanLeong
 * @date: 2020/11/17 11:09
 */
public interface UserService {

    UserModel getUserById(Integer id);
}
