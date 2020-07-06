package com.yang.blog.until;

import com.yang.blog.mapper.UserMapper;
import com.yang.blog.security.configuration.TokenAuthenticationHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by 2020/6/26
 *
 * @author yangyang
 */
public class UserUntil {

    public static String getUser(){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return username;
    }


}
