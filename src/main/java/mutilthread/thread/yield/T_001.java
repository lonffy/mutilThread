package mutilthread.thread.yield;

/**
 * yield方法
 * 让出一会CPU给其他线程,但处理器随时都有可能忽略,也就是测试时多次结果会不一致
 * 注意: 该方法实际开发中很少用,一般用于调试问题和设计多线程程序时用来做测试
 */
public class T_001 {
    public static void main(String[] args) {

        new Thread(new T1()).start();
        new Thread(new T2()).start();
    }
}

class T1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                // 当i==5时,让出一下,让其他线程先执行
                if(i == 5){
                    Thread.yield();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }
}