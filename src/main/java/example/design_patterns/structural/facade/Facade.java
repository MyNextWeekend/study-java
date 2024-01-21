package example.design_patterns.structural.facade;

public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
    }

    public void methodA() {
        one.one();
        three.Three();
    }

    public void methodB() {
        one.one();
        two.Two();
    }
}
