package com.ky.web;/**
 * Created by Ky2Fe on 2022/6/8 0:29
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 测试controller
 **/

@RestController
public class TestController {
    @GetMapping("/get")
    public String test() {
        return "HELLO";
    }
}
