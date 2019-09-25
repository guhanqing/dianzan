package com.example.dianzan.service.impl;

import com.example.dianzan.dao.User;
import com.example.dianzan.dao.UserExample;
import com.example.dianzan.mapper.UserMapper;
import com.example.dianzan.service.UserService;
import com.example.dianzan.vo.req.UserVo;
import com.example.dianzan.vo.res.UserBo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: base
 * @description: 用户操作类接口实现
 * @author: guhq
 * @create: 2019/09/09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBo getUserInfo(UserVo userVo) {
        UserBo rtnUserBo = new UserBo();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userVo.getUsername()).andPasswordEqualTo(userVo.getPassword());
        List<User> userList = userMapper.selectByExample(userExample);
        User user;
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
        } else {
            return null;
        }
        BeanUtils.copyProperties(user, rtnUserBo);
        return rtnUserBo;
    }

}
