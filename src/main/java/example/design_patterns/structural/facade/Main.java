package example.design_patterns.structural.facade;

/**
 * 外观模式调用
 */
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        System.out.println("----------");
        facade.methodB();
    }
}
