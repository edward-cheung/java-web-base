package cn.edcheung.javaWebBase.designPattern;

/**
 * SimpleFactory 简单工厂类
 * 增加产品，需要修改工厂类，违背开闭原则（对扩展开放；对修改封闭）
 *
 * @author Edward Cheung
 * 2019/6/27
 */
class SimpleFactory {
    BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}

// 产品类
abstract class BMW {
    BMW() {
    }
}

class BMW320 extends BMW {
    BMW320() {
        System.out.println("制造-->BMW320");
    }
}

class BMW523 extends BMW {
    BMW523() {
        System.out.println("制造-->BMW523");
    }
}

// 客户类
class Customer1 {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
