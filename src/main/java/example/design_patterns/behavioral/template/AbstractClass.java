package example.design_patterns.behavioral.template;

public abstract class AbstractClass {
    public abstract void method1();

    public abstract void method2();

    public abstract void method3();

    public void templateMethod() {
        this.method1();
        this.method2();
        this.method3();
    }
}
