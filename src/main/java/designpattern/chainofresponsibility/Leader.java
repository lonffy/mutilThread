package designpattern.chainofresponsibility;

public abstract class Leader {
    private Leader leader;
    abstract void approve();
    void setNext(Leader leader){
        this.leader = leader;
    }
    Leader getNext(){
        return leader;
    }
}
