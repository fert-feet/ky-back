package com.ky;/**
 * Created by Ky2Fe on 2022/6/8 22:48
 */

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;

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
        controllerGenerator();
    }

    /**
     * 除了controller以外的生成器
     */
    private static void generator() {
        FastAutoGenerator.create(URL, USER_NAME, PASS_WORD)
                .globalConfig(builder -> {
                    builder.author("KY") // 设置作者
                            .fileOverride()
                            .outputDir("D:\\Project\\JAVA\\admin\\ky-vue-background\\ky-system\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ky") // 设置父包名
                            .entity("domain")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("web");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user,sys_test") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")
                            .entityBuilder()
                            .enableLombok()
                            .mapperBuilder()
                            .enableMapperAnnotation();
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER);
                })
                .execute();
    }

    /**
     * controller生成器
     */
    private static void controllerGenerator() {
        FastAutoGenerator.create(URL, USER_NAME, PASS_WORD)
                .globalConfig(builder -> {
                    builder.author("KY") // 设置作者
                            .fileOverride()
                            .outputDir("D:\\Project\\JAVA\\admin\\ky-vue-background\\ky-admin\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ky") // 设置父包名
                            .controller("web");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")
                            .entityBuilder()
                            .enableLombok()
                            .controllerBuilder()
                            .enableRestStyle(); // 设置过滤表前缀
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.SERVICE, TemplateType.MAPPER, TemplateType.ENTITY, TemplateType.SERVICEIMPL, TemplateType.XML);
                })
                .execute();
    }
}
