package example.study;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {

    /**
     * 创建一个可缓存的线程池，若线程数超过处理所需，缓存一段时间后会回收，若线程数不够，则新建线程。
     */
    @Test
    public void testCachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            int number = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "收到的值是：" + number);
                // 等待2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        pool.shutdown(); // 这将使执行者不接受新线程，并完成队列中的所有现有线程
        while (!pool.isTerminated()) {
        }// 等到所有线程完成，您也可以使用“executor.awaitTermination();”来等待
        System.out.println("done");

    }

    /**
     * 创建一个固定大小的线程池，可控制并发的线程数，超出的线程会在队列中等待。
     */
    @Test
    public void testFixedThreadPool() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int number = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "收到的值是：" + number);
                // 等待2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        pool.shutdown(); // 这将使执行者不接受新线程，并完成队列中的所有现有线程
        while (!pool.isTerminated()) {
        }// 等到所有线程完成，您也可以使用“executor.awaitTermination();”来等待
        System.out.println("done");
    }

    /**
     * 创建一个周期性的线程池，支持定时及周期性执行任务。
     */
    @Test
    public void testScheduledThreadPool() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);


        for (int i = 0; i < 10; i++) {
            final int index = i;
            pool.schedule(() -> {
                System.out.println(Thread.currentThread().getName() + "收到的值是：" + index);
                // 等待2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, 3, TimeUnit.SECONDS);
        }
        pool.shutdown(); // 这将使执行者不接受新线程，并完成队列中的所有现有线程
        while (!pool.isTerminated()) {
        }// 等到所有线程完成，您也可以使用“executor.awaitTermination();”来等待
        System.out.println("done");

    }

    /**
     * 创建一个单线程的线程池，可保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    @Test
    public void testSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 8; i++) {
            final int index = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "收到的值是：" + index);
                // 等待2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    /**
     * ThreadPoolExecutor类提供了4种构造方法，可根据需要来自定义一个线程池。
     * 参数含义如下：
     * 1、corePoolSize：核心线程数，线程池中始终存活的线程数。
     * 2、maximumPoolSize: 最大线程数，线程池中允许的最大线程数。
     * 3、keepAliveTime: 存活时间，线程没有任务执行时最多保持多久时间会终止。
     * 4、unit: 单位，参数keepAliveTime的时间单位，7种可选。
     * 5、workQueue: 一个阻塞队列，用来存储等待执行的任务，均为线程安全，7种可选。
     * 6、threadFactory: 线程工厂，主要用来创建线程，默及正常优先级、非守护线程。
     * 7、handler：拒绝策略，拒绝处理任务时的策略，4种可选，默认为AbortPolicy。
     * 执行规则如下：
     * 1、当线程数小于核心线程数时，创建线程。
     * 2、当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
     * 3、当线程数大于等于核心线程数，且任务队列已满：
     * 若线程数小于最大线程数，创建线程。
     * 若线程数等于最大线程数，抛出异常，拒绝任务。
     */
    @Test
    public void testThreadPoolExecutor() {
        ExecutorService pool = new ThreadPoolExecutor(2, 10, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "收到的值是：" + index);
                // 等待2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        pool.shutdown(); // 这将使执行者不接受新线程，并完成队列中的所有现有线程
        while (!pool.isTerminated()) {
        }// 等到所有线程完成，您也可以使用“executor.awaitTermination();”来等待
        System.out.println("done");
    }

}
