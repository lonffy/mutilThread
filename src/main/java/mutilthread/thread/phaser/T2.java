package mutilthread.thread.phaser;

import java.util.concurrent.Phaser;

/**
 * 模拟一场比赛, 预赛->处赛->预赛
 */
public class T2 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 预赛");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+" 初赛");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+" 决赛");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+" 比赛完毕");
            }).start();
        }
    }
}
