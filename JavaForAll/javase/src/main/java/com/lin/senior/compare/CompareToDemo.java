package com.lin.senior.compare;

import java.util.Arrays;

/**
 * @program: javase
 * @description: Java比较器之 CompareTo方法实现
 * @author: linsz
 * @create: 2022-06-08 02:20
 **/
public class CompareToDemo {
    public static void main(String[] args) {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("huaweiMouse", 31);
        goods[1] = new Goods("xiaomiMouse", 22);
        goods[2] = new Goods("dellMouse", 11);
        goods[3] = new Goods("hpMouse", 22);
        goods[4] = new Goods("appleMouse", 44);

        Arrays.sort(goods);
        for (Goods good : goods) {
            System.out.println(good.getName() + "," + good.getPrice());
        }
    }
}

class Goods implements Comparable {

    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price != goods.price) {
                return Double.compare(this.price, goods.price);
            } else
                return this.name.compareTo(goods.name);
        }
        throw new RuntimeException("类型不合法无法比较");
    }
}
