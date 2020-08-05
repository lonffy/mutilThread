package designpattern.proxy;

public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        SubjectProxy proxy = new SubjectProxy(realSubject);
        proxy.req();//RealSubject req....
    }
}
