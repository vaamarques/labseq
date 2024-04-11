package design.patterns.creational.builder;

public interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}
