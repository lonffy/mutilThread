package designpattern.memento;

/**
 * 备忘录，用于记录某个对象的状态
 */
public class Mememto {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


}
