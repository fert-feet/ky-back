package com.ky.web;

import com.ky.domain.SysTest;
import com.ky.result.ResultVo;
import com.ky.service.ISysTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 测试
     *
     * @return
     */
    @PostMapping("/post")
    public ResultVo test(@Validated @RequestBody SysTest user) {
        return new ResultVo(testService.getById(user.getId()));
    }

}
