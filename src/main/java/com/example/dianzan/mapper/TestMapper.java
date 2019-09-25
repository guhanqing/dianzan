package com.example.dianzan.mapper;


import com.example.dianzan.dao.Test;

/**
 * @program: demo
 * @description: mybatis mapper类
 * @author: guhq
 * @create: 2019/08/31
 */
public interface TestMapper {
    Test getUserInById(Integer id);
}
