package design.patterns.creational.absctractFactory;

public class MacOSButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering a MacOS button");
    }
}
