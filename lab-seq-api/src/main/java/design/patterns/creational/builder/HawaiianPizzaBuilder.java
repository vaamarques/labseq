package design.patterns.creational.builder;

public class HawaiianPizzaBuilder implements PizzaBuilder {
    private final Pizza pizza;

    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    public void buildDough() {
        pizza.setDough("cross");
    }

    public void buildSauce() {
        pizza.setSauce("mild");
    }

    public void buildTopping() {
        pizza.setTopping("ham+pineapple");
    }

    public Pizza getPizza() {
        return pizza;
    }
}