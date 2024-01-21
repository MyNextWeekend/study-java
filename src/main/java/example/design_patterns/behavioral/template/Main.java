package example.design_patterns.behavioral.template;

/**
 * 模板方法调用
 */
public class Main {
    public static void main(String[] args) {
        ConcreteClassA classA = new ConcreteClassA();
        classA.templateMethod();
        System.out.println("-----");
        ConcreteClassB classB = new ConcreteClassB();
        classB.templateMethod();
    }
}
