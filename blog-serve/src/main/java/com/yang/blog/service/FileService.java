package com.yang.blog.service;

import com.yang.blog.until.ResJson;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 2020/7/8
 *
 * @author yangyang
 */
public interface FileService {

    public ResJson saveFile(List<MultipartFile> files);
}
