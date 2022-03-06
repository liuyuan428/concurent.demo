import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class CountDownLatchDemo {

    /**
     * 输出如下，不可循环使用，任务一同时触发，任务二没有同时触发
     * Thread-51645943667完成任务一
     * Thread-81645943667完成任务一
     * Thread-91645943667完成任务一
     * Thread-71645943667完成任务一
     * Thread-61645943667完成任务一
     * Thread-91645943669完成任务二
     * Thread-71645943670完成任务二
     * Thread-81645943671完成任务二
     * Thread-51645943672完成任务二
     * Thread-61645943672完成任务二
     */
    @Test
    public void test() throws InterruptedException {
        int threadNum = 5;
        Random random = new Random(1000);
        CountDownLatch start = new CountDownLatch(1);

        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                try {
                    start.await();
                    System.out.println(Thread.currentThread().getName() + Instant.now().getEpochSecond() + "完成任务一");

                    Thread.sleep(random.nextInt(5000));
                    start.await();
                    System.out.println(Thread.currentThread().getName() + Instant.now().getEpochSecond() + "完成任务二");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //触发
        start.countDown();
        Thread.sleep(10000);
    }

}
