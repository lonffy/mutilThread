package mutilthread.thread.volatitletest;


/**
 * volatile 关键字
 * 作用一: 防止指令重排序
 执行结果:
 Thread-0 cat:mutilthread.thread.volatitletest.Cat@291b58e6
 Thread-1 cat:mutilthread.thread.volatitletest.Cat@28979470
 */
public class T_03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Cat obj = Cat.getInstance();
                System.out.println(Thread.currentThread().getName()+" cat:"+obj);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Cat obj = Cat.getInstance();
                System.out.println(Thread.currentThread().getName()+" cat:"+obj);
            }
        }).start();
    }
}

class Cat {
    private static Cat cat = null;

    public static Cat getInstance(){
        if(cat == null){
            //如果B线程到这里 (B处)
            synchronized (Cat.class) {
                //A线程到这里
                try { //此处休眠的目的是为了让B线程也来到(B处)
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cat = new Cat();
            }
        }
        return cat;
    }
}