package com.yang.blog.security.mapper;

import com.yang.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by 2020/6/23
 *
 * @author yangyang
 */
@Repository
public interface UserDetailMapper extends JpaRepository<User, String> {

    public User findByUsername(String username);

}
