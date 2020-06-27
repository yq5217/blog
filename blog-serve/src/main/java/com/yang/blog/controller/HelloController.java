package com.yang.blog.controller;

import com.yang.blog.until.ResJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 2020/6/21
 *
 * @author yangyang
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public ResJson hello(){
        return ResJson.createBySuccessMessage("hello world!");
    }
}
