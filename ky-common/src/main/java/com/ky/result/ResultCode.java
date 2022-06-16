package com.ky.result;

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

    VALID_DATA(1002, "参数校验错误"),

    RUNTIME_ERROR(1003, "运行时异常"),
    ;

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
    private final String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
