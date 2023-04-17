package com.lin.server.service.impl;

import com.lin.server.service.HelloService;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Objects;

/**
 * @program: webservice
 * @description: HelloService 实现类
 * @author: linsz
 * @create: 2022-09-17 23:01
 **/
@Component
@WebService(name = "HelloServiceImpl",
            targetNamespace = "http://webservice.server.lin.com")
public class HelloServiceImpl implements HelloService {

    /**
     * 根据传入的参数查看是否调用成功
     * @param data
     * @return
     */
    @Override
    public String getInfo(@WebParam String data) {
        if (Objects.isNull(data) || "".equals(data.trim())){
            return "传入的参数为空";
        }
        return "调用成功: "+data;
    }
}
