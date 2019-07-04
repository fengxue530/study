package com.fx.study.config;

import com.fx.study.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 程振奇
 * @date 2018/6/21
 * 用来配置某些功能 例如拦截器
 * 以下三种方式来实现自主配置
 * <p>
 * @EnableWebMvc+extends WebMvcConfigurerAdapter，
 * 在扩展的类中重写父类的方法即可，这种方式会屏蔽springboot的@EnableAutoConfiguration中的设置
 * <p>
 * extends WebMvcConfigurationSupport，
 * 在扩展的类中重写父类的方法即可，这种方式会屏蔽springboot的@EnableAutoConfiguration中的设置
 * <p>
 * extends WebMvcConfigurerAdapter，
 * 在扩展的类中重写父类的方法即可，这种方式依旧使用springboot的@EnableAutoConfiguration中的设置
 * <p>
 * 在springboot2.0中 WebMvcConfigurerAdapter 被废弃  解决方案为 implements WebMvcConfigurer
 * WebMvcConfigurer 基于jdk1.8  里面有默认的 default 方法 不必实现所有接口
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthInterceptor());
    }


    /**
     * 登录接口映射到登录页面
     */
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login").setViewName("login");
    }*/

    @Bean
    public AuthInterceptor getAuthInterceptor() {
        return new AuthInterceptor();
    }

}
