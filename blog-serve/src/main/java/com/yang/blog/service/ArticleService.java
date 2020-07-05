package com.yang.blog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yang.blog.pojo.ArticleContent;
import com.yang.blog.until.ResJson;

/**
 * Created by 2020/7/1
 *
 * @author yangyang
 */
public interface ArticleService {

    public ResJson findInfoAll();

    public ResJson findContentById(String id);

    public ResJson saveContent(String article);
}
