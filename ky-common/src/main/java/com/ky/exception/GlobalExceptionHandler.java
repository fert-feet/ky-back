package com.ky.exception;

import com.ky.result.ResultCode;
import com.ky.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 控制层异常处理
 **/

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理运行时异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResultVo runtimeExceptionHandler(RuntimeException e) {
        log.error("运行时异常---{}", e.getMessage());
        return ResultVo.error().msg(e.getMessage());
    }


    /**
     * 处理数据校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultVo methodArgumentNotValidExceptionHandler(BindException e) {
        //获取错误信息
        ObjectError bindError = e.getBindingResult().getAllErrors().get(0);
        log.error("控制层数据绑定异常---{}", bindError.getDefaultMessage());
        return ResultVo.error().status(ResultCode.VALID_DATA);
    }
}
