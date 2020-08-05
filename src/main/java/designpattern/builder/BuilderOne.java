package designpattern.builder;

public class BuilderOne extends AbstractBuilder{
    @Override
    void buildPartA() {
        product.setPartA("One set PartA");
    }

    @Override
    void buildPartB() {
        product.setPartB("One set PartB");
    }

    @Override
    void buildPartC() {
        product.setPartC("One set PartC");
    }

}
