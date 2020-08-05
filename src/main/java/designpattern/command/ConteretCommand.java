package designpattern.command;

public class ConteretCommand implements Command{
    private Reciever reciever;

    ConteretCommand(){
        reciever = new Reciever();

    }

    @Override
    public void excute() {
        reciever.action();
    }
}
