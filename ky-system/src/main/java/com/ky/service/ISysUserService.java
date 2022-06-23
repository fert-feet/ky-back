package com.ky.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.domain.SysUser;
import com.ky.dto.sys_user.UpdateUserDto;
import com.ky.dto.sys_user.UserDto;
import com.ky.result.ResultVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author KY
 * @since 2022-06-19
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    ResultVo create(UserDto user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    ResultVo update(UpdateUserDto user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    ResultVo delete(int id);

    /**
     * 分页查找
     *
     * @Param: [currentNum, pageSize, userName, nickName]
     * @Return: com.ky.result.ResultVo
     */
    ResultVo pageIndex(int currentNum, int pageSize, String userName, String nickName);
}
