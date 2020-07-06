package com.yang.blog.mapper;

import com.yang.blog.pojo.ArticleContent;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * Created by 2020/7/1
 *
 * @author yangyang
 */
@Resource
public interface ArticleContentMapper extends JpaRepository<ArticleContent, String> {

    java.util.Optional<ArticleContent> findByArticleId(String id);

}
