package com.ky.dto.sysuser;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 创建用户DTO
 **/

@Data
public class UserDto implements Serializable {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户昵称
     */
    @NotBlank
    private String nickName;

    /**
     * 用户名
     */
    @NotBlank
    private String userName;

    /**
     * 密码
     */
    @NotBlank
    private String passWord;

    /**
     * 电话号码
     */
    @NotBlank
    private String phoneNumber;

    /**
     * 邮箱
     */
    @NotBlank
    private String email;

    /**
     * 地址
     */
    @NotBlank
    private String address;
}
