package designpattern.mediator;

public class B extends Person{
    @Override
    public void send() {
        System.out.println("b send a message");
        this.mediator.notice(this);
    }

    @Override
    public void reciev() {
        System.out.println("b reciev a message");
    }
}
