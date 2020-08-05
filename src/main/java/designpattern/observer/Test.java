package designpattern.observer;

public class Test {
    public static void main(String[] args) {
        Subject subject = new ConteretSubject();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObserver();
    }
}
