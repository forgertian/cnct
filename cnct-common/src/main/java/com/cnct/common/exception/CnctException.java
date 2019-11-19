package com.cnct.common.exception;

import com.cnct.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CnctException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}