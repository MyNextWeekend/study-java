package example.design_patterns.structural.adapter;

/**
 * 适配的类
 */
public class Adapter extends Target {
    private final Xyz x = new Xyz();


    @Override
    public void request() { //表面调用request
        x.specificRequest(); //实际调用specificRequest
    }
}
