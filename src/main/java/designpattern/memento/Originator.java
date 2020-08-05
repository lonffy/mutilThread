package designpattern.memento;

public class Originator {
    //自己的内部状态
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    //创建备忘录，创建快照的意思
    public Mememto createMememto(){
        Mememto mememto = new Mememto();
        mememto.setState(this.state);
        return mememto;
    }

    //从备忘录种恢复状态
    public void restoreMememto(Mememto mememto){
        this.state = mememto.getState();
    }

}
