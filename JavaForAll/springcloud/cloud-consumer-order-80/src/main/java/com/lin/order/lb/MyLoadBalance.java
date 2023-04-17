package com.lin.order.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springcloud
 * @description: ILoadBalance实现类
 * @author: linsz
 * @create: 2022-08-18 18:26
 **/
@Component
@Slf4j
public class MyLoadBalance implements ILoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current++;
        }while (this.atomicInteger.compareAndSet(current,next));
        log.info("now the next is =====>{}",next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
