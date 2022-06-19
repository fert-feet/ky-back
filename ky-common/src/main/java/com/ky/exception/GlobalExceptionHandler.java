package com.ky.exception;

import com.ky.result.ResultCode;
import com.ky.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;

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
        return ResultVo.error().status(ResultCode.RUNTIME_ERROR);
    }


    /**
     * 处理传入体参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultVo methodArgumentNotValidExceptionHandler(BindException e) {
        //获取错误信息
        ObjectError bindError = e.getBindingResult().getAllErrors().get(0);
        log.error("传入体参数校验异常---{}", bindError.getDefaultMessage());
        return ResultVo.error().status(ResultCode.VALID_DATA);
    }

    /**
     * 处理传入参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVo methodArgumentNotValidExceptionHandler(MissingServletRequestParameterException e) {
        //获取错误信息
        log.error("传入参数校验异常---{}", e.getMessage());
        return ResultVo.error().status(ResultCode.VALID_DATA);
    }

    /**
     * 处理HTTP异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServletException.class)
    @ResponseBody
    public ResultVo servletExceptionHandler(ServletException e) {
        //获取错误信息
        log.error("HTTP异常---{}", e.getMessage());
        return ResultVo.error().status(ResultCode.HTTP_ERROR);
    }
}
