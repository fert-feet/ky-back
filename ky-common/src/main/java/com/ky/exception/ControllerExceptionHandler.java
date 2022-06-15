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
public class ControllerExceptionHandler {
    @ExceptionHandler({BindException.class})
    @ResponseBody
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e) {

        //获取错误信息
        ObjectError bindError = e.getBindingResult().getAllErrors().get(0);
        log.error("控制层数据绑定异常--------{}", bindError.getDefaultMessage());
        return new ResultVo(ResultCode.VALID_DATA, bindError.getDefaultMessage());

    }
}
