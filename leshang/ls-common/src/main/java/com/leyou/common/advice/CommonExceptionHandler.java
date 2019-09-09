package com.leyou.common.advice;

import com.leyou.common.exception.LyException;
import com.leyou.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 描述:
 *       自定义异常拦截器
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-23 15:25
 */
@ControllerAdvice
public class CommonExceptionHandler {

    //指定拦截异常的类型
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleException(LyException e) {
        return ResponseEntity.status(e.getExceptionEunm().getCode())
                .body(new ExceptionResult(e.getExceptionEunm()));
    }
}
