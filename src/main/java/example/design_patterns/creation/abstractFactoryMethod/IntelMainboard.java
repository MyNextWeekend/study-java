package example.design_patterns.creation.abstractFactoryMethod;

public class IntelMainboard implements IMainboard {
    /**
     * CPU插槽的孔数
     */
    private final int cpuHoles;

    /**
     * 构造方法，传入CPU插槽的孔数
     */
    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}
