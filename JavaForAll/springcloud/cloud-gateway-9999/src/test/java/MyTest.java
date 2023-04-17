import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @program: springcloud
 * @description: 测试类
 * @author: linsz
 * @create: 2022-08-23 15:43
 **/
@SpringBootTest
@Slf4j
public class MyTest {

    @Test
    public void test(){
        ZonedDateTime now = ZonedDateTime.now();
        log.info("predicate 时间设置:{}",now);
    }
}
