package com.example.dianzan.vo.res;

/**
 * @program: base
 * @description: 后端响应前端返回的业务对象
 * @author: guhq
 * @create: 2019/09/09
 */
public class UserBo {
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
