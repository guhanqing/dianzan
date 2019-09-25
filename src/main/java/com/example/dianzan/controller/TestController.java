package com.example.dianzan.controller;

import com.example.dianzan.dao.Test;
import com.example.dianzan.enums.RespMsgEnum;
import com.example.dianzan.config.redis.CacheService;
import com.example.dianzan.service.TestService;
import com.example.dianzan.utils.ResultUtil;
import com.example.dianzan.vo.BaseRequestModel;
import com.example.dianzan.vo.BaseResponseModel;
import com.example.dianzan.vo.req.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: 测试
 * @author: guhq
 * @create: 2019/08/31
 */
@RestController
@RequestMapping(value="/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public String getUserInfo() {
        return "顾汉青";
    }

    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public TestVo getUserById() {
        TestVo test = testService.getUserInById(1);
        return test;
    }

    @RequestMapping(value="/getUserById", method = RequestMethod.POST)
    public TestVo getUserById(@RequestParam(value = "id") Integer id) {
        TestVo test = testService.getUserInById(id);
        return test;
    }

    @RequestMapping(value="/getUserByJosn", method = RequestMethod.POST)
    public BaseResponseModel<Test> getUserById(@RequestBody BaseRequestModel<TestVo> requestModel) {
        cacheService.add("111", "TEST");
        System.out.println(cacheService.get("111"));
        Integer id = requestModel.getReqData().getId();
        TestVo test1 = testService.getUserInById(id);
        if (test1 == null) {
            return ResultUtil.setError(RespMsgEnum.USER_EXIST_ERROR);
        }
        return ResultUtil.setSuccess(test1);
    }
}
