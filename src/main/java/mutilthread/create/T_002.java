package mutilthread.create;

/**
 * 继承Thread类时给线程重命名:
 * 构造方法中调用super(name)
 * 获取线程名称的方法有两个:直接通过线程的对象getName,或者在子线程内部调用Thread.currentThread().getName()
 */
public class T_002 {

    public static void main(String[] args) {
        T2 t2 = new T2("T2子线程");
        System.out.println("main方法中打印T2线程名称: " + t2.getName());
        t2.start();
        // 如果new 一个新的Thread来启动T2,那么获取到的当前线程名称: Thread-0
        new Thread(t2).start();
    }
}

class T2 extends Thread{

    T2(String name){
        super(name);
    }

    @Override
    public void run() {

        System.out.println("线程名称: "+Thread.currentThread().getName());
    }
}