import lombok.extern.slf4j.XSlf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.*;



public class CyclicBarrierTest {

    /**
     * Thread-4所有线程已到达栅栏
     * Thread-21646458412完成任务一
     * Thread-41646458412完成任务一
     * Thread-11646458412完成任务一
     * Thread-31646458412完成任务一
     * Thread-01646458412完成任务一
     * Thread-0所有线程已到达栅栏
     * Thread-11646458413完成任务二
     * Thread-01646458413完成任务二
     * Thread-31646458413完成任务二
     * Thread-21646458413完成任务二
     * Thread-41646458413完成任务二
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        int partiesNum = 5;
        Random random = new Random(1000);
        CyclicBarrier start = new CyclicBarrier(partiesNum,
                () -> System.out.println(Thread.currentThread().getName() + "所有线程已到达栅栏")
        );

        for (int i = 0; i < partiesNum; i++) {
            new Thread(() -> {
                try {
                    //只有 partiesNum 数量的线程调用 await 方法，才会执行
                    start.await();

                    Thread.sleep(random.nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + Instant.now().getEpochSecond()+ "完成任务一");

                    //可循环使用，countDownLatch 不可以
                    start.await();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + Instant.now().getEpochSecond()+ "完成任务二");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        wait();
        Thread.sleep(2000);
    }

}
