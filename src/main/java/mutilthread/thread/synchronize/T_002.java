package mutilthread.thread.synchronize;

/**
 * synchronized 可重入锁
 同一线程对同一个对象锁是可重入的，而且同一个线程可以获取同一把锁多次，也就是可以多次重入
 */
public class T_002 {

    public static void main(String[] args) {
        Person2 person = new Person2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                person.h();
            }
        }).start();
    }
}

class Person2{

    private static Object obj = new Object();

    public synchronized void h(){
        System.out.println(Thread.currentThread().getName());
        // 调用另一个持有同一个锁的方法, 按常理来说,b方法获得了锁, 其他方法
        b();
    }

    public void b(){
        synchronized(this) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
