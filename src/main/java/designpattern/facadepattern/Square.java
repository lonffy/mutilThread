package designpattern.facadepattern;

import designpattern.factorypattern.Shape;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}
