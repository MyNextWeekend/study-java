package example.design_patterns.creation.builderPattern;

public interface IBuilder {
    // 建造部件A
    void buildPartA();

    // 建造部件B
    void buildPartB();

    // 得到产品
    Product getResult();
}
