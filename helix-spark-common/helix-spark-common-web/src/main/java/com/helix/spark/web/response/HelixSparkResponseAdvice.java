package com.helix.spark.web.response;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.helix.spark.i18n.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * All rights Reserved, Designed By www.helix.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.helix.cn Inc. All rights reserved.
 * @date 2023/2/14 10:03
 **/
//@RestControllerAdvice
@Slf4j
public class HelixSparkResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        boolean isExecuteBeforeBody = returnType.getGenericParameterType().equals(Result.class);
        log.debug("The isExecuteBeforeBody is {}",isExecuteBeforeBody);
        return !isExecuteBeforeBody;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}