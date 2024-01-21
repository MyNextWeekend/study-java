package example.design_patterns.creation.simpleFactorMethod;

public class OperationFactory {
    public static IOperation createOperate(String operate) {
        IOperation oper = null;
        switch (operate) {
            case "+":
                oper = new Add();
                break;
            case "-":
                oper = new Sub();
                break;
        }
        return oper;
    }
}
