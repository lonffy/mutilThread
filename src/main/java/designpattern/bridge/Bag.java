package designpattern.bridge;

abstract class Bag {
    public Color color;
    private String bagType;
    public Bag(Color color){
        this.color = color;
    }

    public Bag(){}

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
