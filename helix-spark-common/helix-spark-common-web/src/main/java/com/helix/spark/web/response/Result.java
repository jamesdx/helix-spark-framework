package com.helix.spark.web.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.helix.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.helix.cn Inc. All rights reserved.
 * @date 2023/2/13 12:07
 **/

@Data
@Builder
@Slf4j
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;

    public static <T> Result success(T data) {
        Result result = Result.builder().code(ResultEnum.SUCCESS.getStatusCode()).message(ResultEnum.SUCCESS.getStatusMsg()).data(data).build();
        log.debug("The Result is {}", result.toString());
        return result;
    }
}