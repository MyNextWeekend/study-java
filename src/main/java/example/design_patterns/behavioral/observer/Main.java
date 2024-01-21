package example.design_patterns.behavioral.observer;

/**
 * 观察者模式调用
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("张三", subject));
        subject.attach(new ConcreteObserver("李四", subject));
        subject.attach(new ConcreteObserver("王五", subject));
        subject.attach(new ConcreteObserver("赵六", subject));

        subject.setSubjectState("AAAAA");
        subject.notifyObserver();
        System.out.println("-----");
        subject.setSubjectState("BBBBB");
        subject.notifyObserver();
    }
}
