package com.lin.senior.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Optional;

/**
 * @program: javase
 * @description: Optional测试
 * @author: linsz
 * @create: 2022-06-14 05:40
 **/
public class OptionalDemo {

    @Test
    public void testOptional() {
        Boy boy = new Boy();
        boy = null;
        //System.out.println(Optional.of(boy).isPresent());
        System.out.println(Optional.ofNullable(boy).isPresent());
        System.out.println(Optional.ofNullable(boy).orElse(new Boy("王飞")));

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Boy {
    private String name;
}
