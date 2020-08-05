package designpattern.state;

public class Context {
    public State state;

    public void setState(State state) {
        this.state = state;
    }

    public void excute(){
        state.excute();
    }

}
