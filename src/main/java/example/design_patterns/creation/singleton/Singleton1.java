package example.design_patterns.creation.singleton;

//饿汉式单例类.在类初始化时，已经自行实例化
public class Singleton1 {

    //让构造函数为 private，这样该类就不会被实例化
    private Singleton1() {
    }

    // 创建 SingleObject 的一个对象
    private static final Singleton1 instance = new Singleton1();

    //静态方法获取对象
    public static Singleton1 getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    /**
     * 单例调用--饿汉模式
     */
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        instance.showMessage();

    }
}