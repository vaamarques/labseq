package design.patterns.creational.absctractFactory.cars;

public class BmwCar implements Car{
    @Override
    public void build() {
        System.out.println("Building BMW");
    }
}
