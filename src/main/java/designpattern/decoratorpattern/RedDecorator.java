package designpattern.decoratorpattern;

public class RedDecorator {
    private Shape shape;

    RedDecorator(Shape shape){
        this.shape = shape;
    }

    public void redDraw(){
        shape.draw();
        System.out.println("draw red...");
    }
}
