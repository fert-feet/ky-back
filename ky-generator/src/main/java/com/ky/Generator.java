package com.ky;/**
 * Created by Ky2Fe on 2022/6/8 22:48
 */

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 代码生成器
 **/

public class Generator {

    private static final String URL = "jdbc:mysql://localhost:3306/ky_sys?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";

    private static final String USER_NAME = "root";

    private static final String PASS_WORD = "lwz7254591";

    public static void main(String[] args) {
        generator();
    }

    private static void generator() {
        FastAutoGenerator.create(URL, USER_NAME, PASS_WORD)
                .globalConfig(builder -> {
                    builder.author("KY") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Project\\JAVA\\admin\\ky-vue-background\\ky-system\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ky") // 设置父包名
                            .entity("domain")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .controller("web")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Project\\JAVA\\admin\\ky-vue-background\\ky-system\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_test") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .execute();
    }
}
