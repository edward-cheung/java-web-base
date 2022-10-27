package cn.edcheung.javaWebBase.syntax;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Edward Cheung
 * 2019/1/14
 */
public class Main implements Cloneable {

    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world");

//        // Java 8日期、时间API：LocalDate无法包含时间，LocalTime无法包含日期。当然，LocalDateTime才能同时包含日期和时间
//        // 当前日期
//        LocalDate today = LocalDate.now();
//        System.out.println(today);
//        // 根据年月日取日期
//        LocalDate birthday = LocalDate.of(1996, 9, 16);
//        System.out.println(birthday);
//        // 根据字符串取：
//        LocalDate endOfFeb = LocalDate.parse("2018-02-28");
//        System.out.println(endOfFeb);
//        // 取本月第1天：
//        LocalDate firstDayOfThisMonth = today.withDayOfMonth(1);
//        System.out.println(firstDayOfThisMonth);
//        // 取本月最后一天
//        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
//        System.out.println(lastDayOfThisMonth);
//        // 取下一天
//        LocalDate plusDays = endOfFeb.plusDays(1);
//        System.out.println(plusDays);
//        // LocalTime包含毫秒
//        LocalTime now = LocalTime.now();
//        System.out.println(now);
//        // 清除毫秒数
//        LocalTime editedTime = now.withNano(0);
//        System.out.println(editedTime);
//        // 构造时间
//        LocalTime zero = LocalTime.of(0, 0, 0);
//        System.out.println(zero);
//        // 解析时间
//        LocalTime noon = LocalTime.parse("12:00:00");
//        System.out.println(noon);

//        // 单例模式
//        // 简单工厂模式，又叫做静态工厂方法模式
//        // 工厂方法模式
//        // 抽象工厂模式
//
//        // 注解，枚举类

        System.out.println("123".compareTo("123456"));

        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        System.out.println(TimeZone.getDefault());
        System.out.println(Main.class.getSuperclass().getName());

        new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(33333);
                System.out.println("00000000");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        try {
            Thread.sleep(555);
            lock.lock();
            try {
                lock.lock();
                Thread.sleep(1111);
                System.out.println("00000000");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("111111111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        for (Integer n : list) {
            sum = sum + n;
        }
        return sum;
    }

}