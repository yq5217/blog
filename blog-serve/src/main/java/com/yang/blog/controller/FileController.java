package com.yang.blog.controller;

import com.yang.blog.service.FileService;
import com.yang.blog.until.ResJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 2020/7/7
 *
 * @author yangyang
 */
@Controller
@RequestMapping("/file/")
public class FileController {

    @Resource
    private FileService fileService;

    @RequestMapping("savefile")
    @ResponseBody
    public ResJson saveFile(List<MultipartFile> file){

        return fileService.saveFile(file);
    }
}
