package example.study;

import org.junit.Test;

public class StringTest {
    /**
     * 1、String.trim()：
     * 它去掉的只是String首尾空格，内部不处理；
     * 2、str.replace(" ", “”)：
     * 去掉所有空格，包括首尾、中间，但是又仅仅局限于一个空格
     * 3、str.replaceAll(" +","") ：
     * 可以匹配去掉所有空格
     * 4、str.replaceAll("\s*", “”)：
     * 可以替换大部分空白字符， 不限于空格
     * \s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
     * 5、StringUtils.deleteWhitespace(str)；
     * 这是StringUtils类中封装的方法，可以去除所有空格，并且可以匹配空格、制表符、换页符等
     */
    @Test
    public void test01() {
        String str = "  Ji  m m     y";
        System.out.println("首尾去空格：" + str.trim());
        System.out.println("去掉所有空格，包括首尾、中间：" + str.replace(" ", ""));
        System.out.println("匹配去掉所有空格：" + str.replaceAll(" +", ""));
        System.out.println("可以替换大部分空白字符,不限于空格：" + str.replaceAll("\\s*", ""));
    }
}
