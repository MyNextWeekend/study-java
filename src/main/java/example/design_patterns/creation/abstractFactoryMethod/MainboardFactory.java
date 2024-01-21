package example.design_patterns.creation.abstractFactoryMethod;

public class MainboardFactory {
    public static IMainboard createMainboard(int type) {
        IMainboard mainboard = null;
        if (type == 1) {
            mainboard = new IntelMainboard(755);
        } else if (type == 2) {
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
