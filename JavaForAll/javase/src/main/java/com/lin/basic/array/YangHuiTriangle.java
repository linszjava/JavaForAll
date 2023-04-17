package com.lin.basic.array;

/**
 * @program: Java
 * @description: 杨辉三角实现 打印10行的杨辉三角
 * @author: linsz
 * @create: 2022-06-02 17:28
 **/
public class YangHuiTriangle {
    public static void main(String[] args) {
        int[][] yangHui = new int[10][];
        for (int i = 0; i < yangHui.length; i++) {
            //初始化复制
            yangHui[i] = new int[i + 1];
            yangHui[i][0] = yangHui[i][i] = 1;
            //从第三行开始
            if (i > 1) {
                for (int j = 1; j < yangHui[i].length - 1; j++) {
                    yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];
                }
            }
        }

        /**
         * 遍历
         */
        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j]);
            }
            System.out.println();
        }
    }
}
