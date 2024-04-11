package design.patterns.creational.absctractFactory.cars;

public class PeugeotCar implements Car{
    @Override
    public void build() {
        System.out.println("Building a Peugeot");
    }
}
