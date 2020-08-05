package designpattern.factorypattern;

public abstract class AbstractFactory {
    abstract Color getColor(String shapeType);
    abstract Shape getShape(String shapeType);
}
