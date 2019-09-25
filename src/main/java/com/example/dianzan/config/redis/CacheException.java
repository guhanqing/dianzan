package com.example.dianzan.config.redis;

/**
 * @program: demo
 * @description: 缓存异常类
 * @author: guhq
 * @create: 2019/06/05
 */
public class CacheException extends RuntimeException {
    private String msg;
    public CacheException(Exception ex, String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
