package com.xinput;

import com.xinput.config.database.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 启动类
 * 使用@Import注册动态多数据源
 *
 * @author xinput
 * @date 2017-06-23 20:42
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class QuartzManager {
    public static void main(String[] args) {
        SpringApplication.run(QuartzManager.class, args);
    }
}
