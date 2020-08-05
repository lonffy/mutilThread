package designpattern.mediator;

abstract class Mediator {
    abstract void addPerson(Person person);
    abstract void notice(Person p);
}
