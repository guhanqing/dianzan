package com.example.dianzan.service.impl;

import com.example.dianzan.dao.Test;
import com.example.dianzan.mapper.TestMapper;
import com.example.dianzan.service.TestService;
import com.example.dianzan.vo.req.TestVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description: TestService实现类
 * @author: guhq
 * @create: 2019/09/01
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestVo getUserInById(Integer id) {
        Test test = this.testMapper.getUserInById(id);
        TestVo vo = new TestVo();
        if (test != null) {
            BeanUtils.copyProperties(test, vo);
        } else {
            vo = null;
        }
        return vo;
    }
}
