package example.design_patterns.structural.decorator;

// 具体的服饰类--球鞋
public class Sneakers extends Finery {
    @Override
    public void show() {
        System.out.println("球鞋");
        super.show();
    }
}
