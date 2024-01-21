package example.study_other;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weekend
 */
@Data
@Slf4j
public class JsonTest {
//    使用@Slf4j替代
//    private static Logger logger = LoggerFactory.getLogger(JsonTest.class);
    private String userName;
    private Integer age;


    @Test
    public void test01() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "One");
        map.put("key2", "Two");

        log.info("map:" + map);
        String mapJson = JSON.toJSONString(map);
        log.info("map转json：" + mapJson);

        JsonTest stu = new JsonTest();
        stu.setAge(18);
        stu.setUserName("张三");

        String s = JSON.toJSONString(stu);
        log.info("类对象转换字符串：" + s);

        JSONObject parse = JSON.parseObject(s);
        log.info("字符串转换成json，userName 取值：" + parse.get("userName"));

        JsonTest object = JSON.parseObject(s, JsonTest.class);
        log.info("字符串转换成类对象：" + object);
    }
}
