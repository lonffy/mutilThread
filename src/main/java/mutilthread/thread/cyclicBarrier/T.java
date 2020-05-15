package mutilthread.thread.cyclicBarrier;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 下面模拟一个聚餐的场景, 10个老同学一起聚餐, 开了2桌, 每凑够一桌5人就开吃
 */
public class T {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


        for (int i = 0; i <10 ; i++) {
            new Thread(()->{

                try {
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName()+" 同学到餐馆了");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+" 同学可以开吃了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
