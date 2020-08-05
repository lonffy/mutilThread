package designpattern.prototype;

public class Test {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("long");
        //浅拷贝
        Person person1 = (Person)person.clone();
        System.out.println(person.getName() == person1.getName());

    }
}
