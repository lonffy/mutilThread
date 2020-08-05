package designpattern.state;


public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        State state = new ConteretState();
        context.setState(state);
        context.excute();
        //conteretState excute.. .
    }
}
