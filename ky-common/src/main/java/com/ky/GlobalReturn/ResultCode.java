package com.ky.GlobalReturn;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 返回信息代码枚举
 **/

@Getter
@AllArgsConstructor
public enum ResultCode implements StatusCode {

    SUCCESS(200, "成功"),

    FAIL(1001, "后台错误"),
    ;

    private int code;

    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
