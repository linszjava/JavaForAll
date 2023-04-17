package com.lin.common.result;

import com.lin.common.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springcloud
 * @description: 公共返回类
 * @author: linsz
 * @create: 2022-08-11 20:37
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T>{

    private Integer code;

    private String message;

    private T data;


    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

    /**
     * 普通成功返回  含data
     * @param data
     * @return
     */
    public CommonResult ok(T data){
        return new CommonResult(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage(),data);
    }

    /**
     * 普通失败返回
     * @return
     */
    public CommonResult fail(){
        return new CommonResult(CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMessage(),null);
    }

    public CommonResult fail(Integer code,String message){
        return new CommonResult(code,message,null);
    }


}
