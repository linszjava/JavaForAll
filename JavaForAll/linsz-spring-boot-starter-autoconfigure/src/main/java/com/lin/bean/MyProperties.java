package com.lin.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: linsz-spring-boot-starter-autoconfigure
 * @description: 自定义一个类的配置属性，方便用户在配置文件中进行修改
 * @author: linsz
 * @create: 2022-07-05 03:51
 **/
@ConfigurationProperties("my")
public class MyProperties {

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 后缀
     */
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
