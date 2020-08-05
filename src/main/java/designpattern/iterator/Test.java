package designpattern.iterator;

public class Test {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("111");
        aggregate.add("222");
        aggregate.add("333");
        Iterator iterator = aggregate.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
