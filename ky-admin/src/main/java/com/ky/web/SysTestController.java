package com.ky.web;

import com.ky.GlobalReturn.ResultCode;
import com.ky.GlobalReturn.ResultVo;
import com.ky.service.ISysTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author KY
 * @since 2022-06-09
 */
@RestController
@RequestMapping("/test")
public class SysTestController {

    @Resource
    private ISysTestService testService;

    /**
     * 测试
     *
     * @return
     */
    @GetMapping("/get")
    public ResultVo test() {
        return new ResultVo(ResultCode.FAIL, testService.getById(1));
    }

}
