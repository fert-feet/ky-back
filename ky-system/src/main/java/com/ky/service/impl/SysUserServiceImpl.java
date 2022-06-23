package com.ky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.domain.SysUser;
import com.ky.dto.sys_user.UpdateUserDto;
import com.ky.dto.sys_user.UserDto;
import com.ky.mapper.SysUserMapper;
import com.ky.result.ResultCode;
import com.ky.result.ResultVo;
import com.ky.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author KY
 * @since 2022-06-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public ResultVo create(UserDto user) {
        SysUser sysUser = new SysUser();
        sysUser.setNickName(user.getNickName());
        sysUser.setUserName(user.getUserName());
        sysUser.setPassWord(user.getPassWord());
        sysUser.setPhoneNumber(user.getPhoneNumber());
        sysUser.setEmail(user.getEmail());
        sysUser.setAddress(sysUser.getAddress());
        if (userMapper.insert(sysUser) < 1) {
            return ResultVo.error().status(ResultCode.SQL_ERROR);
        }
        return ResultVo.success().data("id", sysUser.getId());
    }

    @Override
    public ResultVo update(UpdateUserDto user) {
        SysUser sysUser = new SysUser();
        sysUser.setId(user.getId());
        sysUser.setNickName(user.getNickName());
        sysUser.setUserName(user.getUserName());
        sysUser.setPassWord(user.getPassWord());
        sysUser.setPhoneNumber(user.getIphoneNumber());
        sysUser.setEmail(user.getEmail());
        sysUser.setAddress(sysUser.getAddress());
        if (userMapper.updateById(sysUser) < 1) {
            return ResultVo.error().status(ResultCode.SQL_ERROR);
        }
        return ResultVo.success();
    }

    @Override
    public ResultVo delete(int id) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getId, id);
        if (userMapper.exists(wrapper)) {
            userMapper.deleteById(id);
            return ResultVo.success();
        }
        userMapper.deleteById(id);
        return ResultVo.error().status(ResultCode.SQL_ERROR);
    }

    @Override
    public ResultVo pageIndex(int currentNum, int pageSize, String userName, String nickName) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        //判断查询值是否为空
        if (StringUtils.hasLength(userName) || StringUtils.hasLength(nickName)) {
            wrapper.like(SysUser::getUserName, userName).like(SysUser::getNickName, nickName);
        }
        Page<SysUser> page = new Page<>(currentNum, pageSize);
        IPage<SysUser> iPage = userMapper.selectPage(page, wrapper);
        return ResultVo.success().data("userInfo", iPage.getRecords()).data("total", iPage.getTotal());
    }
}
