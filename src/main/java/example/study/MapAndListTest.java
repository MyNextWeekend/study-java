package example.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndListTest {
    @Test
    public void testMsp() {//对列表进行去重处理
        ArrayList<String> objects = new ArrayList<>();
        objects.add("张三");
        objects.add("莉丝");
        objects.add("王五");
        objects.add("张三");


        HashMap<String, String> strMap = new HashMap<>();
        objects.forEach(s -> strMap.put(s, s));     //放入map去重

        ArrayList<String> strings = new ArrayList<>();
        strMap.forEach((s, s1) -> strings.add(s));
        System.out.println(strings);
    }

    @Test
    public void testList() {//对列表进行去重处理
        ArrayList<String> objects = new ArrayList<>();
        objects.add("张三");
        objects.add("莉丝");
        objects.add("赵六");
        objects.add("王五");
        objects.add("张三");

        // 使用filter可用于条件过滤list集合中的元素。filter可以连续使用
        List<String> list = objects.stream()
                .filter(obj -> !obj.equals("张三"))   //去掉张三
                .filter(obj -> !obj.equals("王五"))   //去掉王五
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
