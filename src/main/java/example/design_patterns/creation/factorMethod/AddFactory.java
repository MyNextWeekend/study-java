package example.design_patterns.creation.factorMethod;

public class AddFactory implements IFactory {
    @Override
    public IOperation createOperation() {
        return new Add();
    }
}
