package com.lin.jedis;

import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * @program: springboot-other-tech
 * @description: 模拟发送限时验证码
 * @author: linsz
 * @create: 2022-07-07 00:18
 **/
public class JedisDemo {

    static Jedis jedis;

    static {
        jedis = new Jedis("localhost", 6379);
        jedis.select(7);
    }

    public static void main(String[] args) {
        String code = getCodeWithPhoneNum("292");
        System.out.println(checkCode("292", code));

    }

    //1. 获得一个6位的随机字符串
    private static String getCode() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            stringBuffer.append(rand);
            // System.out.println(stringBuffer);
        }
        return stringBuffer.toString();

    }

    //2.用户输入手机号，获得一个码，两分钟内有效，一天只能获取三次
    public static String getCodeWithPhoneNum(String phoneNum) {

//        用户手机号key
        String phoneNumKey = "PN" + phoneNum;
//        验证码key
        String codeKey = phoneNum + "codeKey";

        String code = null;

        if ((jedis.get(phoneNumKey)) == null) {
//            为空 设置获取次数
            jedis.setex(phoneNumKey, betweenSeconds(), "1");
            //正常来讲，这个getCode要先拿出来放到一个map或者其他地方，以待传给前端
            code = getCode();
            jedis.setex(codeKey, 120, code);
        } else if ((jedis.get(phoneNumKey)) != null && Integer.parseInt(jedis.get(phoneNumKey)) <= 2) {
            jedis.incr(phoneNumKey);
            code = getCode();
            jedis.setex(codeKey, 120, code);
        } else {
            System.out.println("获取超过次数，请明天再试");
        }
//        jedis.close();

        return code;
    }

    //获取过期时间 单位为秒 默认过了晚上12点，重新刷新可以再次获取code
    public static Long betweenSeconds() {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime nextDate = time.plusDays(1);
        int hour = nextDate.getHour();
        int minute = nextDate.getMinute();
        int second = nextDate.getSecond();
        LocalDateTime zeroDate = nextDate.minusHours(hour).minusMinutes(minute).minusSeconds(second);
        long now = time.atZone(ZoneId.systemDefault()).toEpochSecond();
        long nextDateSeconds = zeroDate.atZone(ZoneId.systemDefault()).toEpochSecond();
        long expired = nextDateSeconds - now;

        return expired;
    }

    public static boolean checkCode(String phoneNum, String code) {
        String codeKey = phoneNum + "codeKey";
        String code1 = jedis.get(codeKey);
//        return (Objects.equals(code1,code))?true :false;
        if (Objects.isNull(code1)) {
            return false;
        } else if (Objects.equals(code1, code)) {
            return true;
        } else
            return false;

    }


}
