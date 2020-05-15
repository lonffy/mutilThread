package mutilthread.thread.volatitletest;


/**
 * volatile 关键字
 * 作用一: 防止指令重排序
 执行结果:
 Thread-0 dog:mutilthread.thread.volatitletest.Dog@6d0ca4c7
 Thread-1 dog:mutilthread.thread.volatitletest.Dog@28fe5adb
 */
public class T_02 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Dog dog = Dog.getInstance();
                System.out.println(Thread.currentThread().getName()+" dog:"+dog);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Dog dog = Dog.getInstance();
                System.out.println(Thread.currentThread().getName()+" dog:"+dog);
            }
        }).start();
    }
}

class Dog {
    private static Dog dog= null;

    public static Dog getInstance(){
        if(dog == null){
            try { // 此处休眠是为了看测试结果, 当多个线程都执行到这里时就会生成两个Cat对象
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dog = new Dog();
        }

        return dog;
    }
}