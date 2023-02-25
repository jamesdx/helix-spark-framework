package com.helix.spark.web.response;

import com.helix.spark.core.model.HelixSparkGlobalConstants;
import com.helix.spark.i18n.utils.MessageUtils;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.ZonedDateTime;

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

    private int status;

    private String code = HelixSparkGlobalConstants.UNIFY_RESULT_DEFAULT_SUCCESS_CODE;
    private String message;

    private ZonedDateTime timestamp = ZonedDateTime.now();

    private T data;


    /**
     * returns only status when response is successful
     *
     * @param
     * @return com.helix.spark.web.response.Result
     * @author Allen Wang
     * @date 2023/2/14 11:43
     */

    public static <T> Result success() {
        return Result.builder().status(ResultEnum.SUCCESS.getStatusCode()).build();
    }

    /**
     * Default Success Result
     * code = 200
     * message = ResultEnum.SUCCESS.getStatusMsg()
     *
     * @param data
     * @return com.helix.spark.web.response.Result
     * @author Allen Wang
     * @date 2023/2/14 10:30
     */

    public static <T> Result success(T data) {
        Result result = Result.builder().status(ResultEnum.SUCCESS.getStatusCode()).code("200").message(ResultEnum.SUCCESS.getStatusMsg()).data(data).timestamp(ZonedDateTime.now()).build();
        log.debug("The Result is {}", result.toString());
        return result;
    }

    /**
     * Return Code, Code Refers to Message, and Data
     *
     * @param data code
     * @return com.helix.spark.web.response.Result
     * @author Allen Wang
     * @date 2023/2/14 11:16
     */

    public static <T> Result success(T data, String code) {
        Result result = Result.builder().status(ResultEnum.SUCCESS.getStatusCode()).code(code).message(MessageUtils.getMessage(code)).data(data).timestamp(ZonedDateTime.now()).build();
        log.debug("The Result is {}", result.toString());
        return result;
    }

    /**
     * return status code when response is failure.
     *
     * @param
     * @return com.helix.spark.web.response.Result
     * @author Allen Wang
     * @date 2023/2/14 11:45
     */

    public static <T> Result failWithStatus() {
        return Result.builder().status(ResultEnum.ERROR.getStatusCode()).timestamp(ZonedDateTime.now()).build();
    }

    public static <T> Result fail() {
        Result result = Result.builder().status(ResultEnum.ERROR.getStatusCode()).code(HelixSparkGlobalConstants.UNIFY_RESULT_DEFAULT_FAIL_CODE).message(MessageUtils.getMessage(ResultEnum.ERROR.getStatusMsg())).timestamp(ZonedDateTime.now()).build();
        log.error("Failed API Response: {}", result.toString());
        return result;
    }


    public static <T> Result fail(String code) {
        Result result = Result.builder().status(ResultEnum.ERROR.getStatusCode()).code(code).message(MessageUtils.getMessage(code)).timestamp(ZonedDateTime.now()).build();
        log.error("Failed API Response: {}", result.toString());
        return result;
    }

    public static <T> Result fail(String code, String errorMessage) {
        Result result = null;
        if (StringUtils.isNotEmpty(errorMessage)) {
            result = Result.builder().status(ResultEnum.ERROR.getStatusCode()).code(code).message(errorMessage).timestamp(ZonedDateTime.now()).build();
        } else {
            result = Result.builder().status(ResultEnum.ERROR.getStatusCode()).code(code).message(MessageUtils.getMessage(code)).timestamp(ZonedDateTime.now()).build();
        }
        log.error("Failed API Response: {}", result.toString());
        return result;
    }

}