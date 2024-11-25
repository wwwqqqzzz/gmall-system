package com.gmall.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//swagger配置
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("标准接口")
                .apiInfo(apiInfo("Spring Boot中使用Swagger2构建RESTfulAPIs", "3.0.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gmall.backend"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://ip:port/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("更多请关注: https://blog.csdn.net/xqnode")
                .termsOfServiceUrl("https://blog.csdn.net/xqnode")
                .contact(new Contact("xqnode", "https://blog.csdn.net/xqnode", "xiaqingweb@163.com"))
                .version(version)
                .build();
    }

}
//@Configuration
//@EnableOpenApi
//public class Swagger {
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .enable(true)
//                .groupName("ZRJ")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.smredis.controller"))
//                .paths(PathSelectors.ant("/controller/**"))
//                .build();
//    }
//
//
//    @SuppressWarnings("all")
//    public ApiInfo apiInfo(){
//        return new ApiInfo(
//                "zrj's api",
//                "redis project",
//                "v1.0",
//                "2261839618@qq.com", //开发者团队的邮箱
//                "ZRJ",
//                "Apache 2.0",  //许可证
//                "http://www.apache.org/licenses/LICENSE-2.0" //许可证链接
//        );
//    }
//}
