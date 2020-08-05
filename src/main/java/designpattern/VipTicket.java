package designpattern;

public class VipTicket implements Discount {
    @Override
    public double getPrice(double price) {
        return price * 0.8;
    }
}
