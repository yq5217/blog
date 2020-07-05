package com.yang.blog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.yang.blog.service.ArticleService;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 2020/7/2
 *
 * @author yangyang
 */
@Controller()
@RequestMapping("/article/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("findInfoAll")
    @ResponseBody
    public ResJson findinfoAll(Integer page, Integer limit){
        return articleService.findInfoAll();
    }

    @RequestMapping("findById")
    @ResponseBody
    public ResJson findById(String id){
        return articleService.findContentById(id);
    }

    @RequestMapping("saveArticle")
    @ResponseBody
    public ResJson saveArticle(@RequestBody  String article) throws JsonProcessingException {
        return articleService.saveContent(article);
    }

}
