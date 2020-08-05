package designpattern.memento;


public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("S0");
        System.out.println("originator的状态："+ originator.getState());

        //先将状态备份起来
        CareTaker careTaker = new CareTaker();
        careTaker.setMememto(originator.createMememto());
        System.out.println("已备份originator的状态");
        originator.setState("S1");
        System.out.println("将originator的状态改为："+ originator.getState());
        System.out.println("恢复originator的状态");
        originator.restoreMememto(careTaker.getMememto());
        System.out.println("originator的状态："+ originator.getState());
    }
}
