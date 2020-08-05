package designpattern.facadepattern;

import designpattern.factorypattern.Shape;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}
