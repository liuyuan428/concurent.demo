import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierTest {

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
                    System.out.println(Thread.currentThread().getName() + "完成任务一");

                    start.await();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + "完成任务二");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(2000);
    }

}
