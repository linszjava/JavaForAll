package com.lin.basic.flow_control.family_accout;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Scanner;

/**
 * @program: Java
 * @description: 家庭账户收支情况项目
 * @author: linsz
 * @create: 2022-06-02 15:09
 **/
public class FamilyAccount {
    public static void main(String[] args) {
        boolean isFlag = true;
        int balance = 10000;
        String details = "收支\t\t账户金额\t收支金额\t说    明\n";
        do {
            System.out.println("--------家庭账户收支情况------------");
            System.out.println("        1.收支详细");
            System.out.println("        2.登记支出");
            System.out.println("        3.登记收入");
            System.out.println("        4.退   出");
            System.out.println("                  ");
            System.out.println("        请选择序号  ");

            char selection = FamilyUtil.readMenuSelection();
            switch (selection) {
                case '1':
                    //System.out.println("        1.收支详细");
                    System.out.println(details);
                    System.out.println("============================");
                    break;
                case '2':
                    //System.out.println("        2.登记支出");
                    System.out.println("============================");
                    System.out.println("输入金额");
                    int money = FamilyUtil.readNumber();
                    balance -= money;
                    System.out.println("输入说明");
                    String info = FamilyUtil.readString();
                    details += "支出\t\t" + balance + "\t-" + money + "\t" + info + "\n";
                    System.out.println("输入支出完成");
                    break;
                case '3':
//                    System.out.println("        3.登记收入");
                    System.out.println("============================");
                    System.out.println("输入金额");
                    int moneyAdd = FamilyUtil.readNumber();
                    balance += moneyAdd;
                    System.out.println("输入说明");
                    String infoAdd = FamilyUtil.readString();
                    details += "支出\t\t" + balance + "\t+" + moneyAdd + "\t" + infoAdd + "\n";
                    System.out.println("输入收入完成");
                    break;
                case '4':
                    System.out.println("是否确认退出？ Y/N");
                    char isExit = FamilyUtil.readIsExitChecked();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }

            }
        } while (isFlag);


    }
}
