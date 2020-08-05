package designpattern.builder;

public abstract class AbstractBuilder {
    public Product product = new Product();

    abstract void buildPartA();
    abstract void buildPartB();
    abstract void buildPartC();

    Product buildProduct(){
        buildPartA();
        buildPartB();
        buildPartC();
        return product;
    }
}