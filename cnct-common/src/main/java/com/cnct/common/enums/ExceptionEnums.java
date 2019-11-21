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
    NO_AUTHORIZED(1321,"没有权限的用户");
    private int code;
    private String msg;
}