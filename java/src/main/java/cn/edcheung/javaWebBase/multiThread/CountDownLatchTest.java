package cn.edcheung.javaWebBase.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * Description CountDownLatch 不可重复利用
 *
 * @author Edward Cheung
 * @date 2021/9/9
 * @since JDK 1.8
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        int quantity = 5;
        CountDownLatch countDownLatch = new CountDownLatch(quantity);
        for (int i = 0; i < quantity; i++) {
            new Thread(new Prepare(countDownLatch, i)).start();
        }
        System.out.println("Everyone prepares in position");
        try {
            countDownLatch.await();
            System.out.println("Action");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Prepare implements Runnable {

    private CountDownLatch latch;

    private int no;

    Prepare(CountDownLatch latch, int no) {
        this.latch = latch;
        this.no = no;
    }

    @Override
    public void run() {
        System.out.println(String.format("No %d prepared well", no));
        latch.countDown();
    }
}
