package example.design_patterns.creation.factorMethod;

public class SubFactory implements IFactory {
    @Override
    public IOperation createOperation() {
        return new Sub();
    }
}
