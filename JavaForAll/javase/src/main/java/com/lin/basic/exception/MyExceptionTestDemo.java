package com.lin.basic.exception;

/**
 * @program: javase
 * @description: 测试自定义异常
 * @author: linsz
 * @create: 2022-06-06 03:46
 **/
public class MyExceptionTestDemo {
    public static void main(String[] args) {
        try {
            User user = new User(-3);
        } catch (MyException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}

class User {
    private int id;

    public User(int id) throws MyException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new MyException("该user.id 不能为负数----");
        }

    }
}