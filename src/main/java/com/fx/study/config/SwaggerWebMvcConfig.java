package com.fx.study.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auther: mabaofeng
 * @date: 2019/7/4 09:57
 * @description:
 */
@Configuration
@EnableSwagger2
public class SwaggerWebMvcConfig {

    @Value("${swagger2.enable}")
    private Boolean enableSwagger;

    @Bean
    //前台api接口文档
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                //组名
                .groupName("webApi")
                .apiInfo(webApiInfo())
                //创建ApiSelectorBuilder对象
                .select()
                //过滤掉 admin 接口
                .paths(Predicates.not(PathSelectors.regex("/administrator/.*")))
                //过滤掉 error 接口
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    @Bean
    //后台管理员api文档
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                //创建ApiSelectorBuilder对象
                .select()
                //只显示 admin 接口
                .paths(Predicates.and(PathSelectors.regex("/administrator/.*")))
                .build();
    }


    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("用户中心微服务前台网站API")
                .description("向着月亮进发，即使失败也会落在群星之间")
                .version("1.0")
                .contact(new Contact("fx", "http://oneinchofsunshine.com", "oneinchofsunshine.com@163.com"))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("用户中心微服务后台管理系统的API")
                .description("向着月亮进发，即使失败也会落在群星之间")
                .version("1.0")
                .contact(new Contact("fx", "http://oneinchofsunshine.com", "oneinchofsunshine.com@163.com"))
                .build();
    }
}
