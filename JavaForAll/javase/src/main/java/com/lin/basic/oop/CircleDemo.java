package com.lin.basic.oop;

/**
 * @program: Java
 * @description: 圆的面积测试 考察将对象作为参数进行传递
 * @author: linsz
 * @create: 2022-06-03 23:56
 **/
public class CircleDemo {
    public static void main(String[] args) {
        printAreas(new Circle(), 5);
    }

    public static void printAreas(Circle circle, int time) {
        for (int i = 1; i <= time; i++) {
            circle.radius = i;
            System.out.println("半径是" + circle.radius + "面积是" + circle.findArea());
        }
    }

}

class Circle {

    public double radius;

    public double findArea() {
        return Math.PI * radius * radius;
    }
}
