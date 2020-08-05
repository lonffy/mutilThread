package designpattern.factorypattern;
/**
 * 图形生产工厂
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String shapeType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType){
        if("CIRCLE".equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if("RECTANGLE".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("SQUARE".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }
}
