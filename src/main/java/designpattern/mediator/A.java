package designpattern.mediator;

public class A extends Person{

    @Override
    public void send() {
        System.out.println("a send a message");
        this.mediator.notice(this);
    }

    @Override
    public void reciev() {
        System.out.println("a reciev a message");
    }
}
