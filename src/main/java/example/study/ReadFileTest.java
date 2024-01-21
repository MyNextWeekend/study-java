package example.study;

import org.junit.Test;

public class ReadFileTest {

    @Test
    public void test01() {
        // 不同系统对应的分隔符不一样
        String separator = System.getProperty("file.separator");
        System.out.println(separator);

    }
}
