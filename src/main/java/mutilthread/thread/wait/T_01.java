package mutilthread.thread.wait;

import java.awt.geom.CubicCurve2D;

/**
 * wait和notify:
 * wait将当前线程置入休眠状态，直到在其他线程调用此对象的notify()方法或notifyAll()方法将其唤醒
 * 1、wait和notify方法是Object类的native方法
 * 2、wait方法必须在 同步方法或同步代码块中调用
 * 3、wait()方法可以使调用该线程的方法释放持有当前对象的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒
 * 4、notify()方法可以随机唤醒等待队列中等待的一个线程，并使得该线程退出等待状态，进入可运行状态
 * 案例描述：模拟两个小孩吃糖果,你吃一个再轮到我吃一个
 */
public class T_01 {
    //同一把锁
    private static Object obj = new Object();

    public static void main(String[] args) {
        new Didi(obj).start();
        new Gege(obj).start();
    }
}

class Didi extends Thread{
    private Object lock;

    Didi(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Didi 开始吃糖果...");

            for (int i = 0; i < 10; i++) {
                //吃完第5个糖果就让哥哥吃
                if (i==5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Didi说: 糖果" + i + "非常好吃");
                }
            }
            System.out.println("Didi 吃完糖果了...");
            //弟弟吃完叫哥哥吃
            lock.notify();
        }
    }
}

class Gege extends Thread{
    private Object lock;
    Gege(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Gege 开始吃糖果...");
            for (int i = 0; i < 10; i++) {
                System.out.println("Gege: 糖果" + i + "非常好吃");
                if(i==5){
                    try {
                        //哥哥吃完第5个糖果就叫弟弟吃
                        lock.notify();
                        //哥哥等弟弟吃完
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Gege 吃完糖果了...");

        }
    }

}

