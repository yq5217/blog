package com.yang.blog.mapper;

import com.yang.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * Created by 2020/6/26
 *
 * @author yangyang
 */
@Resource
public interface UserMapper  extends JpaRepository<User, String> {

    public User findByUsername(String username);
}
