package designpattern.command;

public class Test {
    public static void main(String[] args) {
        Command command = new ConteretCommand();
        Invoker invoker = new Invoker();
        invoker.setCommand(command);//这里的command可以是任何接口Command的实现类
        invoker.invoke();
    }
}
