package com.helix.spark.i18n.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * All rights Reserved, Designed By www.hgplan.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.hgplan.cn Inc. All rights reserved.
 * @date 2023/2/13 14:40
 **/
@Slf4j
public class HelixSparkI18nLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getHeader("Accept-Language");
        // 获取默认的语言
        Locale locale = Locale.getDefault();

        // 如果请求的链接携带了国际化参数
        if (!StringUtils.isEmpty(language)) {
            // zh_CN
            String[] split = language.split("_");
            // 国家，地区
            locale = new Locale(split[0], split[1]);
        }
        log.debug("The current Thread Local language is {},country is {} ...", locale.getLanguage(), locale.getCountry());
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

    /**
     * 注入Bean 自定义的国际化组件就生效了
     *
     * @param
     * @return org.springframework.web.servlet.LocaleResolver
     * @author Allen Wang
     * @date 2023/2/13 14:41
     */

    @Bean
    public LocaleResolver localeResolver() {
        return new HelixSparkI18nLocalResolver();
    }
}