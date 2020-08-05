package designpattern.factorypattern;

public class CarFactory {
    public Moveble create(){
        return new Car();
    }
}
