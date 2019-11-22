package com.cnct.common.enums;


import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    /**
     * 1xxxx权限问题
     * 2xxxx用户问题
     * 3xxxx
     * 4xxxx
     */
    WRONG_REQUES_PARAMS(10003,"错误的参数"),
    FAIL_ADD_ROLE(10000,"角色添加失败"),
    FAIL_UPDATE_ROLE(10001,"角色修改失败"),
    FAIL_DELETE_ROLE(10002,"角色删除失败"),
    ROLE_DOES_NOT_EXIST(10002,"该角色不存在"),
    INVALID_VERFIY_CODE(20000,"验证码错误"),
    FAIL_ADD_USER(20000,"用户添加失败"),
    FAIL_COMPLETE_USER(20000,"用户信息完善失败"),
    INVALID_VERFIY_CODE_DISABLED(20001,"验证码已失效"),
    FAIL_DELETE_USER(20002,"删除用户信息失败"),
    FAIL_BANNED_USER(20003,"封禁用户信息失败"),
    INVALID_USERNAME_PASSWORD(20004,"用户名或密码错误"),
    NO_AUTHORIZED(1321,"没有权限的用户");
    private int code;
    private String msg;
}