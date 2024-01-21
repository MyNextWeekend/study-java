package example.design_patterns.structural.agent;

/**
 * 被代理的对象
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
