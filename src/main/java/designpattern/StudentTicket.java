package designpattern;

public class StudentTicket implements Discount {
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}
