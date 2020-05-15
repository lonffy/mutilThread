package mutilthread.thread.reentrantLock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class T {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                h();
            }
        };
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //唤醒
        LockSupport.unpark(thread);
        System.out.println("main unpark");
    }

    public static void h(){
        System.out.println(Thread.currentThread().getName()+" start...");
        // 暂停,等待唤醒
        LockSupport.park();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"continue...");
    }
}
