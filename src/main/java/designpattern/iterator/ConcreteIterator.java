package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator {
    public List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list){
        this.list = list;

    }
    @Override
    public Object first() {
        return list.get(0);
    }

    @Override
    public Object next() {
        if(hasNext()){
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(index < list.size() - 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("111");list.add("222");list.add("333");
        Iterator iterator = new ConcreteIterator(list);
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

}
