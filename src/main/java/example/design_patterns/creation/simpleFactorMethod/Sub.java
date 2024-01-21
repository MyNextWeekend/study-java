package example.design_patterns.creation.simpleFactorMethod;

public class Sub implements IOperation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}
