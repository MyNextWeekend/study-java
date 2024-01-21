package example.study;


import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用于多线程下线程安全的数据读写操作，避免使用锁同步，
 * 底层采用CAS实现，内部的存储值使用volatile修饰，因此多线程之间是修改可见的。
 */
public class AtomicIntegerTest {

    /**
     * 并发安全，自增1
     */
    @Test
    public void test01() {
        // 调用无参构造，相当于传入0
        AtomicInteger number = new AtomicInteger();
        number.getAndIncrement(); //先获取旧值，再自增+1
        number.getAndAdd(5);//先获取旧值，再自增+5
        System.out.println(number.get()); //取最新值
        System.out.println(number.get());
        number.incrementAndGet(); // 先自增+1，在获取值
        number.addAndGet(5); // 先自增+5，在获取值
        System.out.println(number.get()); //取最新值
        System.out.println(number.get());
    }

    /**
     * 并发安全，自减1
     */
    @Test
    public void test02() {
        // 调用无参构造，相当于传入0
        AtomicInteger number = new AtomicInteger();
        number.getAndDecrement(); //先获取旧值，再-1
        number.getAndAdd(-5);//先获取旧值，再-5
        System.out.println(number.get()); //取最新值
        System.out.println(number.get());
        number.decrementAndGet(); // 先-1，在获取值
        number.addAndGet(-5); // 先-5，在获取值
        System.out.println(number.get()); //取最新值
        System.out.println(number.get());
    }

    /**
     * 直接赋值
     */
    @Test
    public void test03() {
        AtomicInteger number = new AtomicInteger();
        number.set(99);// 直接更新为新值，区别于compareAndSet需要比对旧值。
        System.out.println(number.get());//取最新值
    }

}
