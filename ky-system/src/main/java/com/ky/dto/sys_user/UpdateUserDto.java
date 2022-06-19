package com.ky.dto.sys_user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: Ky2Fe
 * @program: ky-vue-background
 * @description: 用户更新
 **/

@Data
public class UpdateUserDto implements Serializable {

    @NotNull
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 电话号码
     */
    private String iphoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;
}
