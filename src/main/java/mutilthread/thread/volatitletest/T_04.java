package mutilthread.thread.volatitletest;


import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile 关键字
 * 作用一: 防止指令重排序
 执行结果:
 Thread-0 cat:mutilthread.thread.volatitletest.Cat@291b58e6
 Thread-1 cat:mutilthread.thread.volatitletest.Cat@28979470
 */
public class T_04 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bike obj = Bike.getInstance();
                System.out.println(Thread.currentThread().getName()+" Bike:"+obj);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bike obj = Bike.getInstance();
                System.out.println(Thread.currentThread().getName()+" Bike:"+obj);
            }
        }).start();
    }
}

class Bike {
    private static Bike bike = null;

    public static Bike getInstance(){
        if(bike == null){ //(关键处)
            //如果B线程到这里 (B处)
            synchronized (Bike.class) {
                //A线程到这里
                try { //此处休眠的目的是为了让B线程也来到(B处)
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(bike == null){ //double check, 基本能保证不会有两个bike对象了
                    //这一步会发生指令重排序
                    //这里准确来说有三步骤: 1) 为bike申请内存空间 2) 调用Bike 构造方法创建对象 3) 将bike指向分配的内人
                    //上面3个步骤中的3) 和 2) 如果发生指令重排就会导致其他线程读到(关键处), 就会不是null, 就直接拿去用, 这时候会发现bike指向一个空的内存空间(因为还没有初始化)
                    bike = new Bike();
                }

            }
        }
        return bike;
    }
}