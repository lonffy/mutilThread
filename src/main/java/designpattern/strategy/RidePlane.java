package designpattern.strategy;

/**
 * 乘坐飞机
 */
public class RidePlane implements Strategy{
    @Override
    public void operate() {
        System.out.println("ride plane");
    }
}
