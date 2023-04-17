package com.lin.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: springcloud
 * @description: 自定义轮询loadBalance接口
 * @author: linsz
 * @create: 2022-08-18 18:24
 **/
public interface ILoadBalance {

    ServiceInstance instances(List<ServiceInstance>serviceInstances);

}
