package example.study;

import java.io.InputStream;
import java.net.URL;

/**
 * @author weekend
 * 读取resources下文件
 */
public class GetResourceTest {
    public static void main(String[] args) {
        URL url1 = GetResourceTest.class.getResource("test1.txt");
        URL url2 = GetResourceTest.class.getResource("/test1.txt");
        URL url3 = GetResourceTest.class.getClassLoader().getResource("test1.txt");
        URL url4 = GetResourceTest.class.getClassLoader().getResource("./test1.txt");
        URL url5 = GetResourceTest.class.getClassLoader().getResource("/test1.txt");
        System.out.println(url1);   //null
        System.out.println(url2);   //有值
        System.out.println(url3);   //有值
        System.out.println(url4);   //有值
        System.out.println(url5);   //null

        System.out.println("------------------------");
        InputStream stream1 = GetResourceTest.class.getClassLoader().getResourceAsStream("test1.txt");
        InputStream stream2 = GetResourceTest.class.getClassLoader().getResourceAsStream("./test1.txt");
        InputStream stream3 = GetResourceTest.class.getClassLoader().getResourceAsStream("/test1.txt");
        System.out.println(stream1);   //有值
        System.out.println(stream2);   //有值
        System.out.println(stream3);   //null
    }
}
