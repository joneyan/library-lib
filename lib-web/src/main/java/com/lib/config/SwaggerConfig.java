package com.lib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @title: SwaggerConfig
 * @package: com.lib.config
 * @description: TODO api生成页面的配置  swagger-ui
 * @author: Yangxiaohui
 * @date Create in 2017/12/31 21:34
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    /**
     * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("index.html")
                .addResourceLocations("classpath:/META-INF/resources/public");

        registry.addResourceHandler("/public/**")
                .addResourceLocations("classpath:/META-INF/resources/public/");
    }

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
//                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
//                .paths((regex("/api/*")))//过滤的接口
                .apis(RequestHandlerSelectors.basePackage("com.lib.controller"))
//                .paths(PathSelectors.any())
                .build()
                .apiInfo(testApiInfo());
    }
//
//    @Bean
//    public Docket demoApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("demo")
//                .genericModelSubstitutes(DeferredResult.class)
////              .genericModelSubstitutes(ResponseEntity.class)
//                .useDefaultResponseMessages(false)
//                .forCodeGeneration(false)
//                .pathMapping("/")
//                .select()
//                .paths((regex("/demo/.*")))//过滤的接口
//                .build()
//                .apiInfo(demoApiInfo());
//    }

    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("IDC(数据处理中心) APIS",//大标题
                "多数据源处理！！！！！",//小标题
                "0.1",//版本
                "NO terms of service",
                "yangxiaohui",//作者
                "localhost:8080/idc",//链接显示文字
                "localhost:8080/idc"//网站链接
        );

        return apiInfo;
    }
//
//    private ApiInfo demoApiInfo() {
//        ApiInfo apiInfo = new ApiInfo("Electronic Health Record(EHR) Platform API",//大标题
//                "EHR Platform's REST API, for system administrator",//小标题
//                "1.0",//版本
//                "NO terms of service",
//                "365384722@qq.com",//作者
//                "The Apache License, Version 2.0",//链接显示文字
//                "http://www.apache.org/licenses/LICENSE-2.0.html"//网站链接
//        );
//
//        return apiInfo;
//    }
}