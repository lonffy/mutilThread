package designpattern.factorypattern;

/**
 * 工厂方法
 */
public class PlaneFactory {
    public Moveble create(){
        return new Plane();
    }
}
