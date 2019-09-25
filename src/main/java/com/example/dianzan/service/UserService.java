package com.example.dianzan.service;

import com.example.dianzan.vo.req.UserVo;
import com.example.dianzan.vo.res.UserBo;

/**
 * @program: base
 * @description: 用户操作类
 * @author: guhq
 * @create: 2019/09/09
 */
public interface UserService {

    UserBo getUserInfo(UserVo userVo);
}
