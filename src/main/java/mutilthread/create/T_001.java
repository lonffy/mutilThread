package mutilthread.create;

/**
 * start()和run()的区别:
 * start()线程进入就绪状态, 等待被CPU调用执行run()方法
 * 直接new T().run()仅仅是执行一个普通方法,没有达到并发的效果
 */
public class T_001 {

    public static void main(String[] args) {
        System.out.println("主线程名称: "+Thread.currentThread().getName());
        //
        new Thread(new T()).start();
        System.out.println("main thread print...");
    }
}

class T extends Thread{

    @Override
    public void run() {
        System.out.println("线程名称: "+Thread.currentThread().getName());
        System.out.println("thread run...");
    }
}