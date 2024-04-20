package example.study_other.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.dto.ResultDto;
import example.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

@Slf4j
public class JacksonTest {
    // 线程安全，可以配置为全局有效
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 方式二：全部设置 不显示null
        // objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);

        // 反序列化的时候，多余字段忽略
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 序列化
     */
    @Test
    public void test01() {
        Student student = new Student();
        // student.setName("张三");
        student.setAge(15);
        student.setSex("男");
        student.setBirthday(new Date());

        try {
            String string = objectMapper.writeValueAsString(student);
            log.info("序列化之后:{}", string);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 反序列化
     */
    @Test
    public void test02() {
        String s = "{\"age\":15,\"age2\":15,\"sex\":\"男\",\"birthday\":\"2024-04-20 12:42:31\"}";

        try {
            Student student = objectMapper.readValue(s, Student.class);
            log.info("反序列化之后:{}", student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 泛型处理
     */
    @Test
    public void test03() throws JsonProcessingException {
        Student student = new Student();
        student.setName("张三三");
        student.setAge(18);
        student.setSex("男");
        student.setBirthday(new Date());

        ResultDto<Student> resultDto = ResultDto.error(301, "错误信息", student);
        String dtoStr = objectMapper.writeValueAsString(resultDto);
        log.info("序列化之后:{}", dtoStr);

        ResultDto<Student> studentResultDto = objectMapper.readValue(dtoStr, new TypeReference<ResultDto<Student>>() {});
        log.info("反序列化之后:{}", studentResultDto);
        log.info("反序列化之后:{}", studentResultDto.getData());
    }
}
