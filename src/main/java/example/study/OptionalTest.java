package example.study;

import org.junit.Test;

import java.util.Optional;

/**
 * 更加安全的判断对象是否为null
 */
public class OptionalTest {
    @Test
    public void test01() throws Exception {
        // 1、Optional 创建 构造方式1 - of 传入的值不能为 null
        Optional<String> helloOption = Optional.of("hello"); // 不能传入null
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> nullOptional = Optional.ofNullable(null); //可以传入null

        // 2、Optional 判断   从 JDK11 开始，提供了 isEmpty 方法用来检查相反的结果
        System.out.println(helloOption.isPresent());
//        System.out.println(helloOption.isEmpty());

        // 3、Optional 获取值 使用 get 方法可以获取值，但是如果值不存在，会抛出 NoSuchElementException 异常
        System.out.println(nullOptional.get());

        // 4、Optional 默认值 使用 orElse, orElseGet（方法可以在没有值的情况下获取给定的默认值）
        System.out.println(emptyOptional.orElse("orElse default"));  // 却都会运行
        System.out.println(emptyOptional.orElseGet(() -> "orElseGet default")); // 有值的情况下并不会运行

        // 5、Optional 异常 使用 orElseThrow 在没有值的时候抛出异常
        helloOption.orElseThrow(() -> new Exception("发现空值"));

        // 6、Optional 函数接口 主要有三个传入函数接口的方法，分别是 filter，map，flatMap
        helloOption.filter(name -> name.equals("123")).ifPresent(name -> System.out.println(name));
        helloOption.map(String::valueOf).map(String::length).ifPresent(length -> System.out.println(length));
    }
}
