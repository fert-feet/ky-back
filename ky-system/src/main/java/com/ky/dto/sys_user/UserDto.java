package com.ky.dto.sys_user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 创建用户DTO
 **/

@Data
public class UserDto implements Serializable {

    /**
     * 用户昵称
     */
    @NotNull()
    private String nickName;

    /**
     * 用户名
     */
    @NotNull
    private String userName;

    /**
     * 密码
     */
    @NotNull
    private String passWord;

    /**
     * 电话号码
     */
    @NotNull
    private String iphoneNumber;

    /**
     * 邮箱
     */
    @NotNull
    private String email;

    /**
     * 地址
     */
    @NotNull
    private String address;
}
