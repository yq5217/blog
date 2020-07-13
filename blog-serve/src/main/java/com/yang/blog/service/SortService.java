package com.yang.blog.service;

import com.yang.blog.pojo.Sort;
import com.yang.blog.until.ResJson;

import java.util.List;

/**
 * Created by 2020/7/13
 *
 * @author yangyang
 */
public interface SortService {

    public ResJson<List<Sort>> findAll();
}
