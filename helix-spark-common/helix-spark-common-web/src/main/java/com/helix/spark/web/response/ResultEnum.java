package com.helix.spark.web.response;

import com.helix.spark.i18n.utils.MessageUtils;

/**
 * All rights Reserved, Designed By www.helix.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.helix.cn Inc. All rights reserved.
 * @date 2023/2/13 19:48
 **/
public enum ResultEnum {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR");

    /**
     * 返回状态码
     */
    private int statusCode;
    /**
     * 返回状态信息
     */
    private String statusMsg;

    ResultEnum(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public String getStatusMsg(){
        return MessageUtils.getMessage(statusMsg);
    }

}