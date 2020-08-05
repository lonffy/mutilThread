package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    public List<Observer> observerList = new ArrayList<Observer>();
    void addObserver(Observer obserber){
        observerList.add(obserber);
    }

    void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    abstract  void notifyObserver();

}
