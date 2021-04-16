package org.jeecg.meeting.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.jeecg.meeting.config.SwaggerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package: com.jzkj.config
 * @ClassName: SwaggerConfiguration
 * @Author: 周毅
 * @CreateTime: 2020/11/16
 * @Description:
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(value = SwaggerProperties.class)
@EnableKnife4j
//@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(value = {"swagger.enabled"}, matchIfMissing = true)
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean(value = "restWeb")
    public Docket createRestWeb(SwaggerProperties swaggerProperties) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("API接口文档")
                                .description("")
                                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                                .contact(new Contact(swaggerProperties.getAuthorName(),
                                        swaggerProperties.getAuthorUrl(),
                                        swaggerProperties.getAuthorEmail()))
                                .version(swaggerProperties.getVersion())
                                .build()).groupName("后台 Web")
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getWebBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /*@Bean(value = "restApi")
    public Docket createRestApi(SwaggerProperties swaggerProperties) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title(swaggerProperties.getTitle())
                                .description(swaggerProperties.getDescription())
                                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                                .contact(new Contact(swaggerProperties.getAuthorName(),
                                        swaggerProperties.getAuthorUrl(),
                                        swaggerProperties.getAuthorEmail()))
                                .version(swaggerProperties.getVersion())
                                .build()).groupName("前台 Api")
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }*/

}
