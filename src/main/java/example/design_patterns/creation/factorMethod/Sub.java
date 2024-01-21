package example.design_patterns.creation.factorMethod;


public class Sub implements IOperation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}
