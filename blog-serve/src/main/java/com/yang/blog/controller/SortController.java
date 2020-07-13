package com.yang.blog.controller;

import com.yang.blog.pojo.Sort;
import com.yang.blog.service.SortService;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 2020/7/13
 *
 * @author yangyang
 */
@Controller
@RequestMapping("/sort/")
public class SortController {

    @Autowired
    private SortService sortService;

    @RequestMapping("findall")
    @ResponseBody
    public ResJson<List<Sort>> findAll(){
        return sortService.findAll();
    }


}
