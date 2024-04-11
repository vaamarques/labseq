package design.patterns.creational.builder;


import design.patterns.creational.absctractFactory.Button;
import design.patterns.creational.absctractFactory.GUIFactory;
import design.patterns.creational.absctractFactory.WindowsFactory;

public class MainBuilder {

    public static void main(String[] args) {

        final PizzaDirector pizzaDirector = new PizzaDirector();

        final PizzaBuilder builder = new HawaiianPizzaBuilder();
        Pizza pizza = pizzaDirector.buildPizza(builder);
        System.out.println("Pizza " + pizza);
    }
}
