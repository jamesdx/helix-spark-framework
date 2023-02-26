package com.helix.spark.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * All rights Reserved, Designed By www.hgplan.cn
 *
 * @author [Allen Wang]
 * @version V1.0
 * Copyright 2023 www.hgplan.cn Inc. All rights reserved.
 * @date 2023/2/26 14:25
 **/
@Slf4j
public class ObjectUtils {
    public static boolean isNull(Object ob){
        log.debug("Use the JDK default Method...");
        return Objects.isNull(ob);
    }
}