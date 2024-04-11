package design.patterns.creational.absctractFactory.cars;

public class BmwFactory implements CarFactory{

    final BmwCar car = new BmwCar();
    @Override
    public Car createCar() {
        return car;
    }
}
