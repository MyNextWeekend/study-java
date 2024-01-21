package example.design_patterns.behavioral.strategy;

public class Context {
    IStrategy strategy;

    public Context(IStrategy strategy) {
        // 传入具体的策略对象
        this.strategy = strategy;
    }

    public void contextInterface() {
        // 根据传入的策略对象，调用具体的算法
        this.strategy.algorithmInterface();
    }
}

