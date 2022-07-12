package com.ky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.domain.SysUser;
import com.ky.dto.sysuser.UserDto;
import com.ky.mapper.SysUserMapper;
import com.ky.result.ResultCode;
import com.ky.result.ResultVo;
import com.ky.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public ResultVo create(UserDto user) {
        SysUser sysUser = new SysUser();
        setUser(user, sysUser);
        if (userMapper.insert(sysUser) < 1) {
            return ResultVo.error().status(ResultCode.SQL_ERROR);
        }
        return ResultVo.success().data("id", sysUser.getId());
    }

    /**
     * 用于setUser，后续应该更改
     *
     * @Param: [user, sysUser]
     * @Return: void
     */
    private void setUser(UserDto user, SysUser sysUser) {
        sysUser.setNickName(user.getNickName());
        sysUser.setUserName(user.getUserName());
        sysUser.setPassWord(user.getPassWord());
        sysUser.setPhoneNumber(user.getPhoneNumber());
        sysUser.setEmail(user.getEmail());
        sysUser.setAddress(sysUser.getAddress());
    }

    @Override
    public ResultVo update(UserDto user) {
        SysUser sysUser = new SysUser();
        sysUser.setId(user.getId());
        setUser(user, sysUser);
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
        //lambda查询工具类
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasLength(userName) || StringUtils.hasLength(nickName)) {
            //模糊查询
            wrapper.like(SysUser::getUserName, userName).like(SysUser::getNickName, nickName);
        }
        //使用Page类查询
        Page<SysUser> page = new Page<>(currentNum, pageSize);
        IPage<SysUser> iPage = userMapper.selectPage(page, wrapper);
        return ResultVo.success().data("userInfo", iPage.getRecords()).data("total", iPage.getTotal());
    }
}
