package cn.edcheung.javaWebBase.syntax;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description DynamicProxy
 *
 * @author Edward Cheung
 * @date 2021/10/14
 * @since JDK 1.8
 */
public class DynamicProxy {

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("say".equals(method.getName())) {
                    System.out.println(args[0]);
                    return args[0];
                }
                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, handler);
        System.out.println(hello.say("Hello"));
    }

}

interface Hello {

    String say(String hi);
}
