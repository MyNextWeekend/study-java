package example.design_patterns.structural.decorator;

//服饰类
public class Finery implements ICharacter {
    private ICharacter component;

    public void decorate(ICharacter component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (this.component != null) {
            this.component.show();
        }
    }
}
