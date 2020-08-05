package designpattern.chainofresponsibility;

public class Test {
    public static void main(String[] args) {
        Leader chairman = new Chairman();
        Leader hrDirector = new HrDirector();
        Leader manager = new Manager();
        manager.setNext(hrDirector);
        hrDirector.setNext(chairman);
        manager.approve();
    }
}
