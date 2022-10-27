package cn.edcheung.javaWebBase.designPattern;

/**
 * AbstractFactory 抽象工厂模式
 *
 * @author Edward Cheung
 * 2019/6/27
 */
//创建工厂的接口
public interface AbstractFactory {
    //制造发动机
    Engine createEngine();

    //制造空调
    AirCondition createAirCondition();
}

//为宝马320系列生产配件
class FactoryBMW320 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public AirCondition createAirCondition() {
        return new AirConditionA();
    }
}

//为宝马523系列生产配件
class FactoryBMW523 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public AirCondition createAirCondition() {
        return new AirConditionB();
    }
}

// 产品类
// 发动机以及型号
interface Engine {
}

class EngineA implements Engine {
    EngineA() {
        System.out.println("制造-->EngineA");
    }
}

class EngineB implements Engine {
    EngineB() {
        System.out.println("制造-->EngineB");
    }
}

//空调以及型号
interface AirCondition {
}

class AirConditionA implements AirCondition {
    AirConditionA() {
        System.out.println("制造-->AirConditionA");
    }
}

class AirConditionB implements AirCondition {
    AirConditionB() {
        System.out.println("制造-->AirConditionB");
    }
}

//客户类
class Customer3 {
    public static void main(String[] args) {
        //生产宝马320系列配件
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createEngine();
        factoryBMW320.createAirCondition();

        //生产宝马523系列配件
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngine();
        factoryBMW523.createAirCondition();
    }
}
