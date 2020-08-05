package designpattern;

public class ChildrenTicket implements Discount {
    @Override
    public double getPrice(double price) {
        return 0;
    }
}
