package com.example._S_Hub_Backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

/**
 * 全局 CORS 配置类
 * 用于配置跨域请求的相关设置
 * 
 * 主要配置：
 * - 允许所有来源的请求
 * - 允许所有请求头
 * - 允许 GET、POST、PUT、DELETE 方法
 * - 允许携带凭证
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")        // 允许所有域名访问
                        .allowedHeaders("*")        // 允许所有请求头
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(false)    // 不允许携带cookie等凭证
                        .exposedHeaders("Header1", "Header2");
            }
        };
    }
}

