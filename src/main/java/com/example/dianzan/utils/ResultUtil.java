package com.example.dianzan.utils;

import com.example.dianzan.enums.RespMsgEnum;
import com.example.dianzan.vo.BaseResponseModel;

/**
 * @program: demo
 * @description: 返回结果工具类
 * @author: guhq
 * @create: 2019/09/01
 */
public class ResultUtil {
    public static BaseResponseModel setSuccess(Object repData) {
        BaseResponseModel baseResponseModel = new BaseResponseModel<>();
        baseResponseModel.setRepData(repData);
        baseResponseModel.setRepCode(RespMsgEnum.SUCCESS.getCode());
        baseResponseModel.setRepMsg(RespMsgEnum.SUCCESS.getMsg());
        baseResponseModel.setSuccess(true);
        return baseResponseModel;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void setSuccess(BaseResponseModel baseResponseModel, Object repData) {
        baseResponseModel.setRepData(repData);
        baseResponseModel.setRepCode(RespMsgEnum.SUCCESS.getCode());
        baseResponseModel.setRepMsg(RespMsgEnum.SUCCESS.getMsg());
        baseResponseModel.setSuccess(true);
    }

    public static BaseResponseModel setError(RespMsgEnum msgEnum) {
        return setError(msgEnum.getCode(), msgEnum.getMsg());
    }

    public static BaseResponseModel setError(String code, String msg) {
        BaseResponseModel baseResponseModel = new BaseResponseModel<>();
        baseResponseModel.setRepCode(code);
        baseResponseModel.setRepMsg(msg);
        baseResponseModel.setSuccess(false);
        return baseResponseModel;
    }
}
