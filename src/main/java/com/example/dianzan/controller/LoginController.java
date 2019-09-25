package com.example.dianzan.controller;

import com.example.dianzan.enums.RespMsgEnum;
import com.example.dianzan.service.UserService;
import com.example.dianzan.utils.ResultUtil;
import com.example.dianzan.vo.BaseRequestModel;
import com.example.dianzan.vo.BaseResponseModel;
import com.example.dianzan.vo.req.UserVo;
import com.example.dianzan.vo.res.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: base
 * @description: 用户登录Controller
 * @author: guhq
 * @create: 2019/09/09
 */
@RestController
@RequestMapping(value="/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public BaseResponseModel<UserBo> getUserById(@RequestBody BaseRequestModel<UserVo> requestModel) {
        UserVo userVo = requestModel.getReqData();
        UserBo userBo = userService.getUserInfo(userVo);
        if (userBo == null) {
            return ResultUtil.setError(RespMsgEnum.USER_EXIST_ERROR);
        }
        return ResultUtil.setSuccess(userBo);
    }

}
