package designpattern.factorypattern;

public class Main {
    public static void main(String[] args) {
        Moveble moveble = new Car();
        moveble.go();

        Moveble moveble1 = new Plane();
        moveble1.go();
    }
}
