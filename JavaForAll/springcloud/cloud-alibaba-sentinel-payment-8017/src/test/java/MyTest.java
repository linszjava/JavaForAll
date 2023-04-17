import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: springcloud
 * @description: 测试获取随机uuid
 * @author: linsz
 * @create: 2022-08-31 20:24
 **/
@SpringBootTest
public class MyTest {

    @Test
    public void getUuid(){
        System.out.println("uuid===============>>"+IdUtil.fastSimpleUUID());
    }
}
