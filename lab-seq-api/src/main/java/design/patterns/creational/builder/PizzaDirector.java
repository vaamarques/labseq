package design.patterns.creational.builder;

public class PizzaDirector {
    public Pizza buildPizza(PizzaBuilder builder) {
        builder.buildDough();
        builder.buildSauce();
        return builder.getPizza();
    }
}
