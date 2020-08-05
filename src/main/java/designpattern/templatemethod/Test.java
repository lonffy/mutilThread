package designpattern.templatemethod;

public class Test {
    public static void main(String[] args) {
        AbstractClass t = new ConteretClass();
        t.templateMethod(2);
    }
}
