package example.design_patterns.behavioral.strategy;

/**
 * 策略方法调用
 */
public class Main {
    public static void main(String[] args) {
        Context context1 = new Context(new ConcreteStrategyA());
        context1.contextInterface();
        System.out.println("------");

        Context context2 = new Context(new ConcreteStrategyB());
        context2.contextInterface();
        System.out.println("------");

        Context context3 = new Context(new ConcreteStrategyC());
        context3.contextInterface();

    }
}
