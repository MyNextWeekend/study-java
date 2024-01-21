package example.design_patterns.creation.abstractFactoryMethod;

public class IntelCpu implements ICpu {
    /**
     * CPU的针脚数
     */
    private final int pins;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("Intel CPU的针脚数：" + pins);
    }
}
