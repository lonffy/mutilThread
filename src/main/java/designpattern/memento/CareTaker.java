package designpattern.memento;

//备忘录管理者
public class CareTaker {
    //报关某个对象的状态，便于恢复
    private Mememto mememto;

    public void setMememto(Mememto mememto) {
        this.mememto = mememto;
    }

    public Mememto getMememto() {
        return mememto;
    }

}
