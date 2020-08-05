package designpattern.decoratorpattern;

public class TestShape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        RedDecorator redDecorator = new RedDecorator(circle);
        redDecorator.redDraw();
    }
}
