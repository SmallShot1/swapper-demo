package com.xkx.swapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2    //开启Swagger2
public class SwaggerConfig {

    //设置多个分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    //配置了Swapper的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //我只希望我的Swapper在生产环境中使用，在发布的时候不使用，将获取的flag赋值给enable
        //设置要显示的Swapper环境
        Profiles profiles = Profiles.of("dev", "test");
        //获取项目当前环境
        //通过environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())

                //设置组名
                .groupName("许可新")
                //是否启用Swapper，如果为false，则Swapper不能在浏览器中访问
                .enable(flag)
                .select()
                //RequestHandlerSelectors   配置要扫描接口的方式
                //basePackage              指定要扫描的包
                //any()                     扫描全部
                //none()                   不扫描
                //withClassAnnotation       扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation      扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.xkx.swapper.controller"))
                //paths()  过滤什么路径
                //.paths(PathSelectors.ant("/xkx/**"))
                .build();

    }

    //配置Swapper信息=apiinfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("许可新", "https://www.baidu.com/", "1722775757@qq.com");

        return new ApiInfo(
                "许可新的SwapperAPI文档",
                "求知若渴，虚心若愚",
                "v1.0",
                "https://www.baidu.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }





}
