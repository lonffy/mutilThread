package designpattern.visit;

/**
 * 元素A，调用访问者的visitA方法
 */
public class ElementA implements Element{
    @Override
    public void accept(Vistor vistor) {
        vistor.visitA(this);
    }
}
