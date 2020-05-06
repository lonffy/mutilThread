package mutilthread.create;

/**
 * 实现Runnable接口时给线程重命名:
 * 1) 增加成员变量name
 * 2) 构造方法赋值name
 * 3) 增加getName方法
 */
public class T_003 {

    public static void main(String[] args) {
        T3 t3 = new T3("T3");
        System.out.println(t3.getName());
    }
}

class T3 implements Runnable{

    private String name;

    T3(String name){
        this.name = name;
    }

    public void run() {

    }

    public String getName() {
        return name;
    }
}