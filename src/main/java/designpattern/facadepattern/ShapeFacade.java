package designpattern.facadepattern;

import designpattern.factorypattern.Shape;
import designpattern.factorypattern.ShapeFactory;

public class ShapeFacade {
    private Circle circle;
    private Rectangle rectangle;
    private Square square;

    private ShapeFacade(){
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCirle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }

    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawCirle();
        shapeFacade.drawRectangle();
        shapeFacade.drawSquare();

    }
}
