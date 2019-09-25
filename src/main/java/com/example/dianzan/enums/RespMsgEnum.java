package com.example.dianzan.enums;

/**
 * @program: demo
 * @description: 响应消息枚举类
 * @author: guhq
 * @create: 2019/09/01
 */
public enum RespMsgEnum {

    SUCCESS("0000", "操作成功"),

    USER_EXIST_ERROR("0001", "用户不存在");

    private final String code;
    private final String msg;

    RespMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
