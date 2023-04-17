package com.lin.server.config;

import com.lin.server.service.HelloService;
import com.lin.server.service.impl.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

/**
 * @program: webservice
 * @description: webService 配置类
 * @author: linsz
 * @create: 2022-09-17 23:09
 **/
@Configuration
public class WebServiceConfig {

    @Autowired
    private HelloService helloService;

    @Bean(Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    /**
     * javax.xml.ws.Endpoint :Endpoint
     * @return
     */
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(springBus(), helloService);
        endpoint.publish("/ws/api");
        return endpoint;
    }
}
