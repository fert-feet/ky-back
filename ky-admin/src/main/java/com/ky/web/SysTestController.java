package com.ky.web;

import com.ky.result.ResultVo;
import com.ky.service.ISysTestService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/test")
public class SysTestController {

    @Resource
    private ISysTestService testService;


    @GetMapping("/get")
    public ResultVo test() {
        return ResultVo.success().data("userInfo", testService.getById(1));
    }

}
