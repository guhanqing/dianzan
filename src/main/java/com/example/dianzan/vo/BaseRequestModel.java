package com.example.dianzan.vo;

import java.io.Serializable;

/**
 * @program: demo
 * @description: 请求泛型封装类
 * @author: guhq
 * @create: 2019/09/01
 */
public class BaseRequestModel <T> implements Serializable {

    private static final long serialVersionUID = -6852928181300554276L;

    private String            token;

    private String            userId;

    private String            sign;

    private String            time;

    private Integer           form;

    private Integer           operateCode;

    private String            operateName;

    private T                 reqData;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public T getReqData() {
        return reqData;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public Integer getOperateCode() {
        return operateCode;
    }

    public void setOperateCode(Integer operateCode) {
        this.operateCode = operateCode;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

}
