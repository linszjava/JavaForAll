package com.lin.basic.flow_control.family_accout;

import java.util.Scanner;

/**
 * @program: Java
 * @description: 用于家庭账户项目选择的工具类
 * @author: linsz
 * @create: 2022-06-02 15:08
 **/
public class FamilyUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String readKeyBoard = readKeyBoard(1);
            c = readKeyBoard.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("输入序号有误，请重新输入");
            } else break;
        }
        return c;
    }

    public static int readNumber() {
        int n;
        for (; ; ) {
            String s = readKeyBoard(4);
            try {
                n = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数据不合法");
            }
        }
        return n;
    }

    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readIsExitChecked() {
        char c;
        for (; ; ) {
            String s = readKeyBoard(4).toUpperCase();
            c = s.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else
                System.out.println("请重新输入");
        }
        return c;
    }


    /**
     * 从键盘上输出一个limit位的数
     *
     * @param limit
     * @return 键盘回车后所接收到的字符串
     */
    private static String readKeyBoard(int limit) {
        String nextLine = "";
        while (scanner.hasNext()) {
            nextLine = scanner.nextLine();
            if (nextLine.length() < 1 || nextLine.length() > limit) {
                System.out.println("输入序号不合法，请重新输入");
                continue;
            }
            break;
        }
        return nextLine;

    }
}
