package com.lin.senior.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: javase
 * @description: Comparetor 比较器的使用
 * @author: linsz
 * @create: 2022-06-08 02:46
 **/
public class ComparetorDemo {
    public static void main(String[] args) {
        Goods[] goods = new Goods[6];
        goods[0] = new Goods("huaweiMouse", 31);
        goods[1] = new Goods("xiaomiMouse", 22);
        goods[2] = new Goods("dellMouse", 11);
        goods[3] = new Goods("hpMouse", 22);
        goods[4] = new Goods("appleMouse", 44);
        goods[5] = new Goods("appleMouse", 144);

        //规定 先按名字排序 在按价格排序 默认都降序
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                } else if (!o1.getName().equals(o2.getName())) {
                    return -(o1.getName().compareTo(o2.getName()));
                } else
                    throw new RuntimeException("输入不合法");

            }
        });
        for (Goods good : goods) {
            System.out.println(good.getName() + ":" + good.getPrice());
        }
    }
}
