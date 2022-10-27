package cn.edcheung.javaWebBase.multiThread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Description FutureTaskTest
 *
 * @author Edward Cheung
 * @date 2021/9/5
 * @since JDK 1.8
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        FutureTask<BigDecimal> task = new FutureTask<>(new Calculator(new BigDecimal("0.7"), new BigDecimal("0.8")));
        // 使用Thread
        new Thread(task).start();
        try {
            System.out.println(task.get(1L, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("----------");

        // 使用线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<FutureTask<BigDecimal>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(task);
            taskList.add(task);
        }
        try {
            for (FutureTask<BigDecimal> futureTask : taskList) {
                System.out.println(futureTask.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Calculator implements Callable<BigDecimal> {

    private BigDecimal a;

    private BigDecimal b;

    Calculator(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(3000L);
        return a.multiply(b).setScale(2, RoundingMode.HALF_UP);
    }
}
