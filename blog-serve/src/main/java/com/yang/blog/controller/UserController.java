package com.yang.blog.controller;

import com.yang.blog.pojo.User;
import com.yang.blog.service.UserService;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 2020/6/26
 *
 * @author yangyang
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserInfo")
    @ResponseBody
    public ResJson<User> getUserInfo(String token){
        return userService.getUserInfo(token);
    }
}
