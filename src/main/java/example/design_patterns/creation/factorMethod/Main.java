package example.design_patterns.creation.factorMethod;

/*
 * 工厂方法调用
 * */
public class Main {
    public static void main(String[] args) {
        IOperation operation = OperationFactory.createOperation("+");
        double result = operation.getResult(12, 12);
        System.out.println(result);
    }
}
