package com.yang.blog.service.serviceImpl;

import com.yang.blog.mapper.SortMapper;
import com.yang.blog.pojo.Sort;
import com.yang.blog.service.SortService;
import com.yang.blog.until.ResJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2020/7/13
 *
 * @author yangyang
 */
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    public ResJson<List<Sort>> findAll(){
        return ResJson.createBySuccess(sortMapper.findAll());
    }
}
