package com.yang.blog.service.serviceImpl;

import com.yang.blog.service.FileService;
import com.yang.blog.until.FileUntil;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Action;
import java.util.List;

/**
 * Created by 2020/7/8
 *
 * @author yangyang
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileUntil fileUntil;

    public ResJson saveFile(List<MultipartFile> files){
        List<String> list = fileUntil.getImgPath(files);
        return ResJson.createBySuccess(list);
    }
}
