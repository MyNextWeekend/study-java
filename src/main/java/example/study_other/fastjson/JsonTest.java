package example.study_other.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import example.model.Teacher;
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


    @Test
    public void test01() {
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setAge(15);
        teacher.setSex("男");

        String teacherJson = JSON.toJSONString(teacher);
        log.info("序列化:{}", teacherJson);

        // 反序列化
        JSONObject parse = JSON.parseObject(teacherJson);
        log.info("字符串转换成json，name 取值：" + parse.get("name"));

        Teacher teacher1 = JSON.parseObject(teacherJson, Teacher.class);
        log.info("反序列化：{}", teacher1);
    }
}
