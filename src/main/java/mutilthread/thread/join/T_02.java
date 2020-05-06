package mutilthread.thread.join;

/**
 * join 方法
 * 1、join() 等待线程结束再继续往下执行
 * 2、join(毫秒) 如果不传毫秒数,默认是0,表示要持续等待
 *
 */
public class T_02 {
    public static void main(String[] args) {
        Thread tt1 =  new Thread(new T2());
        tt1.start();
        try {
            tt1.join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread print");
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ ":" +i);
        }
    }
}
