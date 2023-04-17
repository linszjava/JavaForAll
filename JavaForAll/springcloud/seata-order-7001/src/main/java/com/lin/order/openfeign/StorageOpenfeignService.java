package com.lin.order.openfeign;

import com.lin.common.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: springcloud
 * @description: Storage 客户端接口
 * @author: linsz
 * @create: 2022-09-05 15:29
 **/
@FeignClient("seata-storage-samples")
public interface StorageOpenfeignService {

    @PostMapping("/storage/decrease")
    CommonResult decreaseStorage(@RequestParam("productId")Long productId,
                                        @RequestParam("count") Integer count);
}
