package mutilthread.thread.interrupt;

/**
 * 线程中断 interrupt
 * interrupt() : 给调用线程加入一个中断点，但是不会结束此线程。
 * isInterrupted()：返回此线程的中断状态，但是不会移除此线程中断状态。
 * interrupted()：返回的是当前线程的中断状态，会移除当前线程的中断状态,Thread类的静态方法
 */
public class T_01 {
    public static void main(String[] args) {
        T t = new T();
        t.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        // 调用了t.interrupt()后
        System.out.println("t线程加入中断点后的状态: "+t.isInterrupted());

    }
}


class T extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <300 ; i++) {
            if(i==200){
                // interrupted 是Thread类的静态方法
                Thread.interrupted();
            }
            // 调用 Thread.interrupted(); 后,t线程的中断状态为false,说明已经将中断状态移除了
            System.out.println(this.getName()+"线程【"+i+"】中断状态:"+Thread.currentThread().isInterrupted());
        }
    }
}