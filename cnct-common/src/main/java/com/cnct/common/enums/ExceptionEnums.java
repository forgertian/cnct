package com.cnct.common.enums;


import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    NO_AUTHORIZED(1321,"没有权限的用户");
    private int code;
    private String msg;
}