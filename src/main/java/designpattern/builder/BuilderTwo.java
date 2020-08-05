package designpattern.builder;

public class BuilderTwo extends AbstractBuilder{
    @Override
    void buildPartA() {
        product.setPartA("Two set PartA");
    }

    @Override
    void buildPartB() {
        product.setPartB("Two set PartB");
    }

    @Override
    void buildPartC() {
        product.setPartC("Two set PartC");
    }
}
