package com.yang.blog.mapper;

import com.yang.blog.pojo.ArticleContent;
import com.yang.blog.pojo.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2020/7/1
 *
 * @author yangyang
 */
@Resource
public interface ArticleInfoMapper extends JpaRepository<ArticleInfo, String> {

}
