package example.design_patterns.creation.simpleFactorMethod;


/**
 * 简单工厂调用
 */
public class Main {
    public static void main(String[] args) {
        IOperation operate = OperationFactory.createOperate("-");
        double result = operate.getResult(12, 23);
        System.out.println(result);
    }
}



