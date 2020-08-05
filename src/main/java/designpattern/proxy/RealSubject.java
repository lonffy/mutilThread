package designpattern.proxy;

public class RealSubject implements Subject{
    @Override
    public void req() {
        System.out.println("RealSubject req....");
    }
}
