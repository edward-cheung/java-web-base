package cn.edcheung.javaWebBase.designPattern;

/**
 * Singleton 单例模式
 * 当一个类的对象只需要或者只可能有一个时，应该考虑单例模式。
 * 如果一个类的实例应该在JVM初始化时被创建出来，应该考虑使用饿汉式单例。
 * 如果一个类的实例不需要预先被创建，也许这个类的实例并不一定能用得上，也许这个类的实例创建过程比较耗费时间，也许就是真的没必须提前创建。那么应该考虑懒汉式单例。
 * 在使用懒汉式单例的时候，应该考虑到线程的安全性问题。
 *
 * @author Edward Cheung
 * 2019/5/14
 */

class Singleton1 {
    /**
     * 饿汉式单例
     * 在类被加载的时候对象就会实例化，避免了线程安全问题。
     * 这也许会造成不必要的消耗，因为有可能这个实例根本就不会被用到。而且，如果这个类被多次加载的话也会造成多次实例化。
     * 其实解决这个问题的方式有很多，下面提供两种解决方式，第一种是使用静态内部类的形式，第二种是使用懒汉式。
     */
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    static Singleton1 getInstance() {
        return instance;
    }
}

class Singleton2 {
    /**
     * 静态内部类式(推荐)
     * 只有显示通过调用 getInstance 方法时，才会显示装载 InnerClassSingleton 类，从而实例化 instance。
     * 初始化静态数据时，Java提供了的线程安全性保证。(所以不需要任何的同步)
     */
    private static class InnerClassSingleton {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    static Singleton2 getInstance() {
        return InnerClassSingleton.INSTANCE;
    }
}

enum Singleton3 {
    /**
     * 枚举式
     * 防止多次实例化，即使是在面对复杂的序列化或者反射攻击的时候(安全)
     */
    Singleton_3;

    Singleton3() {
    }
}

class Singleton4 {
    /**
     * 懒汉式
     * 存在线程安全问题
     */
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

class Singleton5 {
    /**
     * 线程安全的懒汉式
     */
    private static Singleton5 instance;

    private Singleton5() {
    }

    public static synchronized Singleton5 getInstance() {
        if (instance == null) {
            instance = new Singleton5();
        }
        return instance;
    }
}

class Singleton6 {
    /**
     * 线程安全的懒汉式
     * 双重校验锁：使用同步代码块的方式减小了锁的范围，双重检查锁定
     */
    private static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
