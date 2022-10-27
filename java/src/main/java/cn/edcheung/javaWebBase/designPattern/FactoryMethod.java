package cn.edcheung.javaWebBase.designPattern;

/**
 * FactoryMethod 工厂方法模式
 * 增加产品，需要增加新的工厂类，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。
 *
 * @author Edward Cheung
 * 2019/6/27
 */
public interface FactoryMethod {
    BMW createBMW();
}

class FactoryMethod320 implements FactoryMethod {
    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }
}

class FactoryMethod523 implements FactoryMethod {
    @Override
    public BMW523 createBMW() {
        return new BMW523();
    }
}

// 客户类
class Customer2 {
    public static void main(String[] args) {
        FactoryMethod320 FactoryMethod320 = new FactoryMethod320();
        BMW320 bmw320 = FactoryMethod320.createBMW();

        FactoryMethod523 FactoryMethod523 = new FactoryMethod523();
        BMW523 bmw523 = FactoryMethod523.createBMW();
    }
}
