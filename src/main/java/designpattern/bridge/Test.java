package designpattern.bridge;

public class Test {
    public static void main(String[] args) {
        Bag handBag = new HandBag();
        Bag wallet = new Wallet();
        handBag.setColor(new Red());
        wallet.setColor(new Yellow());
        System.out.println(handBag.getBagType()+":"+handBag.getColor().draw());
        System.out.println(wallet.getBagType()+":"+wallet.getColor().draw());

    }
}
