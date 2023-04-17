package com.lin.senior.enum1;

/**
 * @program: javase
 * @description: enum 使用
 * @author: linsz
 * @create: 2022-06-08 04:31
 **/
public class EnumDemo {
    public static void main(String[] args) {
        Status status = Status.BAD;
        System.out.println(status + ":" + status.getCode() + ":" + status.getDesc());
        System.out.println(Status.valueOf("GOOD").getDesc());
        for (Status value : Status.values()) {
            System.out.println(value);
        }
    }

}

enum Status {
    GOOD(111, "好"),
    BAD(222, "不好"),
    NORMAL(333, "正常"),
    EXCELLENT(444, "极好");

    private final int code;
    private final String desc;

    Status(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
