package designpattern.mediator;


abstract class Person {
    protected Mediator mediator;

    //每个人都要知道谁来协调，这样才能通知中介者
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void send();
    abstract void reciev();
}
