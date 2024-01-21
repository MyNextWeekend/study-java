package example.design_patterns.creation.abstractFactoryMethod;

/**
 * 抽象工厂方法调用
 */
public class Main {
    public static void main(String[] args) {
        ComputerEngineer cf = new ComputerEngineer();
        cf.makeComputer(1, 1);
    }
}
