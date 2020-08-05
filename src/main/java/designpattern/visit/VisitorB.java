package designpattern.visit;

public class VisitorB implements Vistor{
    @Override
    public void visitA(ElementA elementA) {
        System.out.println("VisitorA visit ElementA");
    }

    @Override
    public void visitB(ElementB elementB) {
        System.out.println("VisitorB visit ElementB");
    }
}

