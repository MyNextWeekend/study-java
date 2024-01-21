package example.study;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发安全的map
 */
public class ConcurrentHashMapTest {

    @Test
    public void test01() {
        ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", "two");
        System.out.println(hashMap);


    }
}
