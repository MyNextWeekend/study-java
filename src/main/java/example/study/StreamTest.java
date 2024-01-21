package example.study;

import example.model.Student;
import example.model.Teacher;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
    /**
     * list 转 map
     */
    @Test
    public void test01() {
        List<Student> students = Arrays.asList(
                new Student("张三", 18, "男", new Date()),
                new Student("莉丝", 19, "女", new Date()),
                new Student("王五", 10, "男", new Date()),
                new Student("赵六", 15, "女", new Date())
        );

        // 方法一：key和value 都为对象的属性
        Map<String, String> map = students.stream().collect(Collectors.toMap(
                Student::getName,
                Student::getSex,
                (k1, k2) -> k1      // 如果出现key值重复，就保留第一个
        ));
        System.out.println(map);

        // 方法二：key和value 都为对象的属性
        Map<String, String> map2 = students.stream().collect(Collectors.toMap(
                obj -> obj.getName() + "-" + obj.getAge(),
                Student::getSex,
                (k1, k2) -> k1          // 如果出现key值重复，就保留第一个
        ));
        System.out.println(map2);

        // 方法三：value 为对象本身
        Map<String, Student> map3 = students.stream().collect(Collectors.toMap(
                Student::getName,
                obj -> obj,
                (key1, key2) -> key2        // 如果出现key值重复，就保留第一个
        ));
        System.out.println(map3);

        // 方法四：value 为对象本身
        Map<String, Student> map4 = students.stream().collect(Collectors.toMap(
                Student::getName,
                Function.identity(),
                (key1, key2) -> key2        // 如果出现key值重复，就保留第一个
        ));
        System.out.println(map4);

        // 方法五：value 转换为其他对象
        Map<String, Teacher> map5 = students.stream().collect(Collectors.toMap(
                Student::getName,
                student -> {
                    Teacher teacher = new Teacher();
                    teacher.setName(student.getName());
                    teacher.setAge(student.getAge());
                    teacher.setSex(student.getSex());
                    return teacher;
                },
                (key1, key2) -> key2        // 如果出现key值重复，就保留第一个
        ));
        System.out.println(map5);
    }

}
