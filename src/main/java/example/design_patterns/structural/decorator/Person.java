package example.design_patterns.structural.decorator;

public class Person implements ICharacter {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的" + name);
    }
}
