package com.yang.blog.mapper;

import com.yang.blog.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 2020/6/27
 *
 * @author yangyang
 */
public interface MenuMapper extends JpaRepository<Menu, String> {

    public List<Menu> findAll();
}
