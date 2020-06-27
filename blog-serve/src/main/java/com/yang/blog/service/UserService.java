package com.yang.blog.service;

import com.yang.blog.pojo.User;
import com.yang.blog.until.ResJson;

/**
 * Created by 2020/6/26
 *
 * @author yangyang
 */
public interface UserService {

    public ResJson<User> getUserInfo(String token);
}
