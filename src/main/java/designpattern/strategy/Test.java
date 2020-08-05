package designpattern.strategy;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        RideBus rideBus = new RideBus();
        context.setStrategy(rideBus);
        context.strategyMethod(); // ride bus
    }
}
