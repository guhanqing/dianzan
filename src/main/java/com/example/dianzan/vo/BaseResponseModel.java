package com.example.dianzan.vo;

import com.example.dianzan.enums.RespMsgEnum;

import java.io.Serializable;

/**
 * @program: demo
 * @description: 响应泛型封装类
 * @author: guhq
 * @create: 2019/09/01
 */
public class BaseResponseModel<T> implements Serializable {

    private static final long serialVersionUID = 8967099995266175783L;

    private boolean success = true;

    private String repCode;

    private String repMsg;

    private T repData;

    public BaseResponseModel() {
        this.repCode = RespMsgEnum.SUCCESS.getCode();
        this.repMsg = RespMsgEnum.SUCCESS.getMsg();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRepCode() {
        return repCode;
    }

    public void setRepCode(String repCode) {
        this.repCode = repCode;
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg;
    }

    public T getRepData() {
        return repData;
    }

    public void setRepData(T repData) {
        this.repData = repData;
    }
}
