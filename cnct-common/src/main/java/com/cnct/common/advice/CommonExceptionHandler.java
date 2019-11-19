package com.cnct.common.advice;

import com.cnct.common.enums.ExceptionEnums;
import com.cnct.common.exception.CnctException;
import com.cnct.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(CnctException.class)
    public ResponseEntity<ExceptionResult> handleException(CnctException e){
        //我们暂定返回状态码为400， 然后从异常中获取友好提示信息
        ExceptionEnums exceptionEnums = e.getExceptionEnums();
        ExceptionResult result = new ExceptionResult(exceptionEnums);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}