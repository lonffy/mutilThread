package mutilthread.thread.reentrantLock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class T2 {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                h();
            }
        };
        thread.start();
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                h();
            }
        };
        thread2.start();
    }

    public static void h(){
        System.out.println(Thread.currentThread().getName()+" start...");
        lock.lock();
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11111111111");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+"continue...");
    }
}
