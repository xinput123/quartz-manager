package com.xinput.config.database;

import java.lang.annotation.*;

/**
 * 数据源注解，用于切换数据源
 *
 * @author xinput
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
