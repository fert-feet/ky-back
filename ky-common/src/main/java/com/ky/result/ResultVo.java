package com.ky.result;

import lombok.Data;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 统一返回类
 **/

@Data
public class ResultVo {

    //状态码
    private int code;

    //状态信息
    private String msg;

    //数据
    private Object data;

    /**
     * 自定义状态码，状态信息，数据
     *
     * @param code
     * @param msg
     * @param data
     */
    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义数据，返回成功状态
     *
     * @param data
     */
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * 自定义状态码和数据
     *
     * @param statusCode
     * @param data
     */
    public ResultVo(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    /**
     * 自定义状态码
     *
     * @param statusCode
     */
    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }
}
