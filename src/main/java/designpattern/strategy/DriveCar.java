package designpattern.strategy;

/**
 * 开车
 */
public class DriveCar implements Strategy{
    @Override
    public void operate() {
        System.out.println("drive car ");
    }
}
