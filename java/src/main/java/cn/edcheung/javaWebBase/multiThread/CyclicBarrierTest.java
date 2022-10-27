package cn.edcheung.javaWebBase.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description CyclicBarrier 可重复利用
 *
 * @author Edward Cheung
 * @date 2021/9/9
 * @since JDK 1.8
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        // 5个家人
        int familyQuantity = 5;
        System.out.println("起床了");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(familyQuantity, () -> System.out.println("开饭了" + System.currentTimeMillis()));
        new Thread(new Family(cyclicBarrier, "grandfather", 2000L)).start();
        new Thread(new Family(cyclicBarrier, "father", 4000L)).start();
        new Thread(new Family(cyclicBarrier, "mather", 4000L)).start();
        new Thread(new Family(cyclicBarrier, "son", 1000L)).start();
        new Thread(new Family(cyclicBarrier, "daughter", 1000L)).start();

    }
}

class Family implements Runnable {

    // 一天三顿饭
    private static final int MEAL_QUANTITY = 3;

    private CyclicBarrier barrier;

    // 姓名
    private String name;

    // 工作时间
    private long workTime;

    public Family(CyclicBarrier barrier, String name, long workTime) {
        this.barrier = barrier;
        this.name = name;
        this.workTime = workTime;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < MEAL_QUANTITY; i++) {
                System.out.println(String.format("%s is waiting for this meal", name));
                barrier.await();
                Thread.sleep(workTime);
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
