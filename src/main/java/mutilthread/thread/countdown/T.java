package mutilthread.thread.countdown;

import java.util.concurrent.CountDownLatch;

public class T {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 开始运行");
                countDownLatch.countDown(); //不会发生阻塞
                System.out.println(Thread.currentThread().getName()+" 运行结束");
            }).start();
        }
        try {
            countDownLatch.await(); // 阻塞
            System.out.println("所有子线程都执行完毕, 继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
