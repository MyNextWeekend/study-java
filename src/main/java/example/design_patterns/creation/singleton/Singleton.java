package example.design_patterns.creation.singleton;

public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    /**
     * 单例调用--懒汉模式
     */
    public static void main(String[] args) {
        Singleton instance = Singleton.getSingleton();
        instance.showMessage();
    }
}
