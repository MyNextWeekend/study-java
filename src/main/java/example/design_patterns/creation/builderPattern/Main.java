package example.design_patterns.creation.builderPattern;

/**
 * 建造者模式调用
 */
public class Main {
    public static void main(String[] args) {
        ConcreteBuilder1 builder1 = new ConcreteBuilder1();
        ConcreteBuilder2 builder2 = new ConcreteBuilder2();
        Director director = new Director();

        // 指挥者创建产品
        director.build(builder1);
        // 拿到真正的产品
        Product result = builder1.getResult();
        // 调用产品的方法
        result.show();

        System.out.println("---------");

        // 指挥者创建产品
        director.build(builder2);
        // 拿到真正的产品
        Product result2 = builder2.getResult();
        // 调用产品的方法
        result2.show();
    }
}
