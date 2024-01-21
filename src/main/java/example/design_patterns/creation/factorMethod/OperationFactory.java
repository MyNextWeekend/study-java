package example.design_patterns.creation.factorMethod;

public class OperationFactory {
    public static IOperation createOperation(String operate) {
        IOperation oper = null;
        IFactory factory = null;
        switch (operate) {
            case "+":
                factory = new AddFactory();
                break;
            case "-":
                factory = new SubFactory();
                break;
        }
        oper = factory.createOperation();
        return oper;
    }

}
