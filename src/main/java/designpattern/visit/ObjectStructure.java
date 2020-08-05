package designpattern.visit;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    List<Element> list = new ArrayList<>();

    /**
     * 添加元素，ObjectStructure就是用于管理所有的元素
     * @param element
     */
    public void addElement(Element element){
        if(!list.contains(element)){
            list.add(element);
        }
    }

    /**
     * 每次增加一个访问者，就让元素去接受 ，这样访问者就可以访问到元素
     * @param vistor
     */
    public void addVisitor(Vistor vistor){
        for(Element element:list){
            element.accept(vistor);
        }
    }
}
