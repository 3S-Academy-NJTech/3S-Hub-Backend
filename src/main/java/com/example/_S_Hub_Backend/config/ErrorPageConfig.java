package com.example._S_Hub_Backend.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 错误页面配置类
 * 用于后端API项目的错误处理配置
 */
@Configuration
public class ErrorPageConfig {

    /**
     * 配置Servlet Web服务器工厂
     * 后端API项目的基础配置
     * 
     * @return ConfigurableServletWebServerFactory 配置好的服务器工厂
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        // 后端API项目通常通过GlobalExceptionHandler处理错误
        // 不需要错误页面重定向
        return factory;
    }
}
      
