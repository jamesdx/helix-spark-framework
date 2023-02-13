package com.helix.spark.i18n.utils;

import com.helix.spark.core.spring.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * All rights Reserved, Designed By www.helix.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.helix.cn Inc. All rights reserved.
 * @date 2023/2/13 15:05
 **/
@Slf4j
public class MessageUtils {
    private MessageUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final MessageSource messageSource = SpringUtils.getBean(MessageSource.class);

    public static String getMessage(String messageKey) {
        try {
            return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
        } catch (Exception ex) {
            log.error("System can not load the {} message ", messageKey);
            return messageKey;
        }

    }

}