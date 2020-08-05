package designpattern.factorypattern;
/**
 * 颜色生产工厂
 */
public class ColorFactory extends AbstractFactory{
    @Override
    Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String shapeType){
        if("Red".equalsIgnoreCase(shapeType)){
            return new Red();
        }else if("Blue".equalsIgnoreCase(shapeType)){
            return new Blue();
        }else if("Yellow".equalsIgnoreCase(shapeType)){
            return new Yellow();
        }
        return null;
    }
}
