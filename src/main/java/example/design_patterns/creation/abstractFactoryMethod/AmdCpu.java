package example.design_patterns.creation.abstractFactoryMethod;

public class AmdCpu implements ICpu {
    /**
     * CPU的针脚数
     */
    private final int pins;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}
