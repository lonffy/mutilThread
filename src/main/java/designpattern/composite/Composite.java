package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    List<Component> list = new ArrayList<Component>();

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void operation(){

        for(Component component:list){
            component.operation();
        }
    }

}
