package example.design_patterns.structural.decorator;

/**
 * 装饰器模式调用
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("张三");
        TShirts tShirts = new TShirts(); //T恤实例对象
        tShirts.decorate(person); //装饰张三

        Sneakers sneakers = new Sneakers(); //球鞋实例对象
        sneakers.decorate(tShirts); //装饰已经有装饰的张三

        sneakers.show();
    }
}
