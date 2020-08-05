package designpattern.observer;


public class ConteretSubject extends Subject {
    @Override
    void notifyObserver() {
        for(Observer observer:observerList){
                observer.response();
        }
    }

}
