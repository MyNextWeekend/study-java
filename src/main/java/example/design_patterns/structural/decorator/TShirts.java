package example.design_patterns.structural.decorator;

// 具体的服饰类--大T恤
public class TShirts extends Finery {
    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}
