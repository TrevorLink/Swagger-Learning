package com.hyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author HuangSir
 * @date 2021-11-02 15:29
 */
@Configuration
@EnableSwagger2//开启Swagger
public class SwaggerConfig {
   @Bean
   public Docket docket(Environment environment){
      //设定要开启Swagger的环境，我们这边指定为dev
      Profiles profiles = Profiles.of("dev");
      //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
      boolean flag = environment.acceptsProfiles(profiles);
      //向容器中注入docket实例的时候需要传递一个apiInfo的实例
      return  new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(apiInfo())
              .groupName("小黄鸭")
              .enable(true)
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.hyy.controller"))
              .paths(PathSelectors.ant("/test/**"))//即只显示@RequestMapping请求路径是test的接口
              .build();
   }
   @Bean
   public Docket docketPro(){
      return new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(apiInfo())
              .groupName("大黄鸭")
              .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build();
   }
   private ApiInfo apiInfo(){
      //Contact对象配置作者信息，ApiInfo实例需要一个作者的实例信息
      Contact contact = new Contact("小黄鸭","www.github.com/TrevorLink","2845964844@qq.com");
      return  new ApiInfo(
              "小黄鸭的Swagger api文档",
              "芜湖",
              "945.945",
              null,
              contact,
              null,
              null,
              new ArrayList<>()
      );
   }
}
