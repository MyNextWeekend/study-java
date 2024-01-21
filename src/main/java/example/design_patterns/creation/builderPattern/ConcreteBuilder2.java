package example.design_patterns.creation.builderPattern;

public class ConcreteBuilder2 implements IBuilder {
    //私有的产品对象信息
    private final Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
