package designpattern.composite;

public class Leaf implements Component{
    private String name;
    Leaf(String name){
        this.name = name;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public void operation() {
        System.out.println("树叶"+name+"被访问");
    }
}
