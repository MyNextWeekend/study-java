package example.design_patterns.behavioral.observer;

import java.util.ArrayList;

abstract class Subject {
    ArrayList<IObserver> list = new ArrayList<>();

    //增加观察者
    public void attach(IObserver observer) {
        list.add(observer);
    }

    //减少观察者
    public void detach(IObserver observer) {
        list.remove(observer);
    }

    //通知观察者
    public void notifyObserver() {
        for (IObserver item : this.list) {
            item.update();
        }
    }

    protected String subjectState;

    public String getSubjectState() {
        return this.subjectState;
    }

    public void setSubjectState(String value) {
        this.subjectState = value;
    }

}
