package com.lin.designpatter;

/**
 * @program: javase
 * @description: 设计模式：模板模式
 * @author: linsz
 * @create: 2022-06-05 21:14
 **/
public class TemplateDemo {

    public static void main(String[] args) {
        Template subTemplate = new SubTemplate();

        long start = System.currentTimeMillis();  //3. 此处代指一部分模板

        subTemplate.code();   //5. 中间是为该模板中需要变换的代码部分

        long end = System.currentTimeMillis();  //4. 此处代指一部分模板

        System.out.println("@@@@@@@@@运行时间为：" + (end - start));
    }


}

abstract class Template {

    //1. 声明一个抽象方法 以待子类重写调用
    abstract public void code();
}

class SubTemplate extends Template {

    //2.子类继承实现重写该方法
    public void code() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }

    }
}