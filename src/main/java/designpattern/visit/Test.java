package designpattern.visit;

public class Test {
    public static void main(String[] args) {
        // 实例化两个访问者
        Vistor vistorA = new VisitorA();
        Vistor vistorB = new VisitorB();

        //实例化两个元素
        Element elementA = new ElementA();
        Element elementB = new ElementB();

        //实例化对象结构，用于管理所有的元素
        ObjectStructure objectStructure = new ObjectStructure();

        // 往对象结构中增加对象
        objectStructure.addElement(elementA);
        objectStructure.addElement(elementB);

        // 添加两个访问者，访问者都可以访问对象结构中的所有元素
        objectStructure.addVisitor(vistorA);
        objectStructure.addVisitor(vistorB);


    }
}
