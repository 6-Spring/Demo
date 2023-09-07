package com.xiaozheng.demo01.utils;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/7 16:35
 */
public class BootException extends RuntimeException {
    private Integer code;
    public BootException(String message, int code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

