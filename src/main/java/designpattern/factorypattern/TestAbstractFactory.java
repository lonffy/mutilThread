package designpattern.factorypattern;

public class TestAbstractFactory {
    public static void main(String[] args) {
        // 获取图形工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color = colorFactory.getColor("red");
        color.fill();

    }
}
