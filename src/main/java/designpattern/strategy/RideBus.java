package designpattern.strategy;

/**
 * 乘坐公交车
 */
public class RideBus implements Strategy{
    @Override
    public void operate() {
        System.out.println("ride bus");
    }
}
