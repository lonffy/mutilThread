package designpattern;

public class MovieTicket {
    private double price;

    private Discount discount;

    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        mt.setPrice(100);
        mt.setDiscount(new StudentTicket());
        System.out.println(mt.getPrice());
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return discount.getPrice(this.price);
    }

}
