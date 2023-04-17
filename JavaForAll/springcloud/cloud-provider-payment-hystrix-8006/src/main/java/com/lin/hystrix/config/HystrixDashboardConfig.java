package com.lin.hystrix.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description: hystrix dashboard 仪表盘 配置
 * @author: linsz
 * @create: 2022-08-22 16:56
 **/
@Configuration
public class HystrixDashboardConfig {

    /**
     * 需要在hystrix dashboard 上面访问的微服务 需要进行如下的配置
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
         HystrixMetricsStreamServlet streamServlet =
                 new HystrixMetricsStreamServlet();
         ServletRegistrationBean registrationBean =
                 new ServletRegistrationBean(streamServlet);
         registrationBean.setLoadOnStartup(1);
         registrationBean.addUrlMappings( "/hystrix.stream" );
         registrationBean.setName( "HystrixMetricsStreamServlet" );
        return registrationBean;
    }
}
