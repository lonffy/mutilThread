package mutilthread.thread.sleep;

/**sleep方法
 * 1、sleep 是一个static native方法
 * 2、Thread.sleep(1000) 单位为毫秒
 * 3、Thread.sleep(毫秒,纳秒) , 1毫秒 = 1000微妙、1微妙 = 1000纳秒
 * 4、Thread.sleep 在哪个线程上下文中执行,就哪个线程休眠
 */
public class T_001 {
    public static void main(String[] args) {
        new T().start();
    }
}

class T extends Thread{

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run_"+i);
        }
    }
}