package org.jeecg.meeting.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package: com.jzkj.config
 * @ClassName: SwaggerProperties
 * @Author: 周毅
 * @CreateTime: 2020/11/16
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "swagger")
@Component
public class SwaggerProperties {

    /**
     * 是否启用
     */
    private boolean enabled;
    /**
     * 标题
     */
    private String title;

    /**
     * 文档描述
     */
    private String description;

    /**
     * 项目路径
     */
    private String termsOfServiceUrl;

    /**
     * 作者
     */
    private String authorName;

    /**
     * 邮箱
     */
    private String authorEmail;

    /**
     * 作者主页
     */
    private String authorUrl;

    /**
     * 版本
     */
    private String version;

    /**
     * web扫描的路径
     */
    private String webBasePackage;

    /**
     * API扫描的路径
     */
    private String apiBasePackage;

}
