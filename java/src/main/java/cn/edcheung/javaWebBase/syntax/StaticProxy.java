package cn.edcheung.javaWebBase.syntax;

public class StaticProxy {

    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy(helloService);
        helloServiceProxy.say("hello world");
    }
}

class HelloService implements Hello {

    @Override
    public String say(String hi) {
        return hi;
    }
}

class HelloServiceProxy implements Hello {

    private Hello hello;

    public HelloServiceProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String say(String hi) {
        System.out.println("前置处理");
        String s = hello.say(hi);
        System.out.println("后置处理");
        return s;
    }
}
