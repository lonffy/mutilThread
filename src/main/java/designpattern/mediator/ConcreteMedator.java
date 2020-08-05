package designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMedator extends Mediator {

    // 中介者服务的人都放这里
    List<Person> personList = new ArrayList<Person>();

    // 每次增加人的时候，同时告诉客户，是我来服务你了。
    @Override
    public void addPerson(Person person) {
        if (!personList.contains(person)) {
            personList.add(person);
            person.setMediator(this);
        }

    }

    // 中介者通知其他人
    @Override
    public void notice(Person p) {
        for (Person person : personList) {
            if (!person.equals(p)) {
                person.reciev();
            }


        }
    }
}
