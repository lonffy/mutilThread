package designpattern.builder;

public class Test {
    public static void main(String[] args) {
        BuilderOne builderOne = new BuilderOne();
        Product product = builderOne.buildProduct();
        System.out.println(product);

        BuilderTwo builderTwo = new BuilderTwo();
        Product product2 = builderTwo.buildProduct();
        System.out.println(product2);
    }
}
