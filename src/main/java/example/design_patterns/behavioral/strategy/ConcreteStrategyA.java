package example.design_patterns.behavioral.strategy;

public class ConcreteStrategyA implements IStrategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法A实现");
    }
}
