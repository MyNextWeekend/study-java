package example.design_patterns.behavioral.observer;

//具体的观察者类
public class ConcreteObserver implements IObserver {
    private final String name;
    private final Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("观察者" + this.name + "新的状态是：" + this.subject.getSubjectState());
    }
}
