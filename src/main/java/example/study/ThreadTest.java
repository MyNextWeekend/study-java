package example.study;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    /**
     * 多线程例子
     */
    @Test
    public void test01() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "start...");
        };

        Thread t1 = new Thread(runnable, "t1-");
        Thread t2 = new Thread(runnable, "t2-");
        Thread t3 = new Thread(runnable, "t3-");
        t1.start();
        t2.start();
        t3.start();
        t1.join(); //阻塞主线程，等待子线程结束
        t2.join(); //阻塞主线程，等待子线程结束
        t3.join(); //阻塞主线程，等待子线程结束
        System.out.println("end");

    }

    /**
     * 设置子线程报错方法处理
     */
    @Test
    public void test02() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer a = 1 / 0;
            System.out.println(Thread.currentThread().getName() + "start...");
        };

        Thread t1 = new Thread(runnable, "t1-");
        t1.setUncaughtExceptionHandler( // 子线程如果报错自动调用方法
                (Thread t, Throwable e) -> {
                    System.out.println("MyDefaultExceptionHandler: Thread: " +
                            t.getName() + ", Message: " + e.getMessage());
                });
        t1.start();
        t1.join(); //阻塞主线程，等待子线程结束
        System.out.println("end");

    }

    /**
     * 获取子线程结果
     */
    @Test
    public void test03() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "start...");
            return 3;
        });

        new Thread(task, "t1-").start(); // 由于有返回值，不需要采用join的方式等待子线程结束
        Integer value = task.get(); //会阻塞主线程直到拿到结果
        System.out.println("获取结果是: " + value);

    }

    /**
     * 获取子线程结果。并考虑子线程异常
     */
    @Test
    public void test04() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer a = 1 / 0;
            System.out.println(Thread.currentThread().getName() + "start...");
            return 3;
        });

        new Thread(task, "t1-").start(); //由于子线程有返回值，报错也封装到了返回体中
        Integer value;
        try {
            value = task.get(); //如果子线程异常没有返回值，这里会报错
        } catch (Exception e) {
            System.out.println(e);
            value = 1;

        }
        System.out.println("获取结果是: " + value);

    }
}
