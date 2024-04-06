package example.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author weekend
 * @date 2024/04/06
 */
public class ProxyTest {

    interface IHello {
        void sayHello(String name);
    }

    public static void main(String[] args) {
        ClassLoader loader = IHello.class.getClassLoader();
        Class<?>[] classes = {IHello.class};
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理方法执行");
                return null;
            }
        };


        IHello iHello = (IHello)Proxy.newProxyInstance(loader, classes, invocationHandler);
        iHello.sayHello("hello");
    }
}
