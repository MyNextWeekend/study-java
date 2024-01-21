package example.design_patterns.creation.builderPattern;

//指挥者
public class Director {
    public void build(IBuilder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
