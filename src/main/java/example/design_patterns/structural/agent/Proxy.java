package example.design_patterns.structural.agent;

/**
 * 代理对象
 */
public class Proxy implements ISubject {
    private final RealSubject rs;

    public Proxy() {
        this.rs = new RealSubject();
    }

    @Override
    public void request() {
        this.rs.request();
    }
}
