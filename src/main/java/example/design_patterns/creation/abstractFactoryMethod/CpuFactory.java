package example.design_patterns.creation.abstractFactoryMethod;

public class CpuFactory {

    public static ICpu createCpu(int type) {
        ICpu cpu = null;
        if (type == 1) {
            cpu = new IntelCpu(755);
        } else if (type == 2) {
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}
