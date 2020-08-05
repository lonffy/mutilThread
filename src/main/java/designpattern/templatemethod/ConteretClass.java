package designpattern.templatemethod;

public class ConteretClass extends AbstractClass{
    @Override
    void extendmethod1() {
        System.out.println("ConteretClass extend method1");
    }

    @Override
    void extendmethod2() {
        System.out.println("ConteretClass extend method2");
    }

    @Override
    void hookMethod() {
        System.out.println("ConteretClass hook method");
    }
}
