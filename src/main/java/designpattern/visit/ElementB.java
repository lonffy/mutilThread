package designpattern.visit;

/**
 * 元素B，调用Vistor中的visiB方法
 */
public class ElementB implements Element{
    @Override
    public void accept(Vistor vistor) {
        vistor.visitB(this);
    }
}
