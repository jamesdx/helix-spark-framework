package com.helix.spark.exception;

import com.helix.spark.web.response.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * All rights Reserved, Designed By www.helix.cn
 * Global Exception Handler For REST API
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.helix.cn Inc. All rights reserved.
 * @date 2023/2/14 14:21
 **/
@RestControllerAdvice
@Slf4j
public class HelixSparkGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = BizException.class)
    public Result bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("System has Exception the...");
        return Result.fail(e.getErrorCode(), e.getErrorCode());
    }
}