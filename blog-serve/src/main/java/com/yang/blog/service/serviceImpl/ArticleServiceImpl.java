package com.yang.blog.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.blog.mapper.ArticleContentMapper;
import com.yang.blog.mapper.ArticleInfoMapper;
import com.yang.blog.pojo.ArticleContent;
import com.yang.blog.pojo.ArticleInfo;
import com.yang.blog.pojo.User;
import com.yang.blog.service.ArticleService;
import com.yang.blog.service.UserService;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 2020/7/1
 *
 * @author yangyang
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private ArticleContentMapper articleContentMapper;

    @Autowired
    private UserService userService;

    public ResJson findInfoAll(){
        List<ArticleInfo> list = articleInfoMapper.findAll();
        return ResJson.createBySuccess(list);
    }
    public ResJson findContentById(String id){
        Optional<ArticleContent> articleContent = articleContentMapper.findByArticleId(id);
        return ResJson.createBySuccess(articleContent.get());
    }

    public ResJson saveInfo(ArticleInfo articleInfo){
        articleInfo = articleInfoMapper.save(articleInfo);
        return ResJson.createBySuccess(articleInfo);
    }

    public ResJson saveContent(String article) {
        try {
            ArticleContent articleContent = new ObjectMapper().readValue(article, ArticleContent.class);
            ArticleInfo articleInfo = articleContent.getArticleInfo();
            //获得用户信息
            User user = userService.getUserInfo();
            //保存文章详情
            articleInfo.setAuthorId(user.getId());
            articleInfo.setAuthor(user.getNickname());
            articleInfo = articleInfoMapper.save(articleInfo);
            //保存文章内容
            if ("".equals(articleContent.getId())){
                articleContent.setId(null);
            }
            articleContent.setArticleId(articleInfo.getId());
            articleContent = articleContentMapper.save(articleContent);
            return ResJson.createBySuccess(articleContent);
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResJson.createByError();

    }

}
