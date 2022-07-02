package com.ky.web;

import com.ky.dto.sysuser.UpdateUserDto;
import com.ky.dto.sysuser.UserDto;
import com.ky.result.ResultVo;
import com.ky.service.ISysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author KY
 * @since 2022-06-19
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private ISysUserService userService;

    /**
     * 查找所有用户
     *
     * @return
     */
    @GetMapping("/index")
    public ResultVo index(@RequestParam int currentNum,
                          @RequestParam int pageSize,
                          @RequestParam(defaultValue = "") String userName,
                          @RequestParam(defaultValue = "") String nickName) {
        return userService.pageIndex(currentNum, pageSize, userName, nickName);
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @PutMapping("/save")
    public ResultVo save(@RequestBody @Validated UserDto user) {
        return userService.create(user);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @PatchMapping("/update")
    public ResultVo update(@RequestBody @Validated UpdateUserDto user) {
        return userService.update(user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public ResultVo delete(@RequestParam(value = "id", required = true) int id) {
        return userService.delete(id);
    }
}
