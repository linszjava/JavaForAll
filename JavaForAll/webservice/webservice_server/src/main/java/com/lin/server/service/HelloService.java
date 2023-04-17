package com.lin.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @program: webservice
 * @description: webservice 接口类
 * @author: linsz
 * @create: 2022-09-17 22:51
 **/

@WebService(serviceName = "HelloService", targetNamespace = "http://webservice.server.lin.com")
public interface HelloService {

    @WebMethod
    String getInfo(@WebParam String data);
}
