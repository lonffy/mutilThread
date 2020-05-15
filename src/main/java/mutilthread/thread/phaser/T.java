package mutilthread.thread.phaser;

import java.util.concurrent.Phaser;

/**
 * 模拟一场考试, 全部考完就公布大家的成绩
 */
public class T {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"考试完毕");
                phaser.arriveAndAwaitAdvance();
                System.out.println("公布了"+Thread.currentThread().getName()+"的成绩");
            }).start();
        }
    }
}
