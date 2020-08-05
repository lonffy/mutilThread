package designpattern.visit;

/**
 * 访问者A，以后增加其他元素，还要往这里增加方法，这就是访问者模式不好的地方
 */
public class VisitorA implements Vistor{
    @Override
    public void visitA(ElementA elementA) {
        System.out.println("VisitorA visit ElementA");
    }

    @Override
    public void visitB(ElementB elementB) {
        System.out.println("VisitorB visit ElementB");
    }
}

