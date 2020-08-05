package designpattern.mediator;

public class Test {
    public static void main(String[] args) {
        // 创建中介者
        Mediator mediator = new ConcreteMedator();
        // 用户A
        A a = new A();
        // 用户B
        B b = new B();
        //中介者要服务谁，A
        mediator.addPerson(a);
        //中介者要服务谁，B
        mediator.addPerson(b);
        //a 发送消息，b接收
        a.send();
        //b 发送消息，a接收
        b.send();

    }
}
