package com.helix.spark.exception;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.hgplan.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.hgplan.cn Inc. All rights reserved.
 * @date 2023/2/14 14:26
 **/
@Data
public class BizException extends RuntimeException {
    /**
     * Error Code which defend in i18n files.
     *
     * @param null
     * @return
     * @author Allen Wang
     * @date 2023/2/14 14:29
     */
    private String errorCode;

    /**
     * Error Message which defend in i18n files.
     *
     * @param null
     * @return
     * @author Allen Wang
     * @date 2023/2/14 14:29
     */
    private String errorMsg;

    public BizException() {
        super();
    }

    public BizException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}