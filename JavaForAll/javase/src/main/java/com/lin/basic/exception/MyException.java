package com.lin.basic.exception;

/**
 * @program: javase
 * @description: 自定义异常
 * @author: linsz
 * @create: 2022-06-06 03:44
 **/
public class MyException extends Exception {
    static final long serialVersionUID = -3387513324229948L;

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }

}
