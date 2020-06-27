package com.yang.blog.service.serviceImpl;

import com.yang.blog.mapper.UserMapper;
import com.yang.blog.pojo.User;
import com.yang.blog.security.pojo.UserDetail;
import com.yang.blog.service.UserService;
import com.yang.blog.until.ResJson;
import com.yang.blog.until.UserUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 2020/6/26
 *
 * @author yangyang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public ResJson<User> getUserInfo(String token){
        User user=  userMapper.findByUsername(UserUntil.getUserByToken(token));
        return ResJson.createBySuccess(user);
    }
}
