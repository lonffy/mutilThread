package mutilthread.thread.synchronize;

/**
 * synchronized 关键字
 * 注: 打印线程堆栈技巧: 打断点, 使用IDEA的线程快照功能
 * 1、修饰方法
 * 1-1) 修饰普通方法, 锁定的是当前对象
 "Thread-0@487" prio=5 tid=0xe nid=NA runnable
 java.lang.Thread.State: RUNNABLE
 at mutilthread.thread.synchronize.Person.h(T_001.java:54)
 - locked <0x1f3> (a mutilthread.thread.synchronize.Person)
 at mutilthread.thread.synchronize.T_001$1.run(T_001.java:19)
 at java.lang.Thread.run(Thread.java:748)
 * 1-2) 修饰静态方法, 锁定的是当前类(xxx.class)
 "Thread-0@487" prio=5 tid=0xe nid=NA runnable
 java.lang.Thread.State: RUNNABLE
 at mutilthread.thread.synchronize.Person.t(T_001.java:69)
 - locked <0x1e4> (a java.lang.Class)
 at mutilthread.thread.synchronize.T_001$1.run(T_001.java:32)
 at java.lang.Thread.run(Thread.java:748)
 * 2、修饰代码块
 * 2-1) 锁定this, 锁定的是当前对象
 "Thread-0@487" prio=5 tid=0xe nid=NA runnable
 java.lang.Thread.State: RUNNABLE
 at mutilthread.thread.synchronize.Person.b(T_001.java:83)
 - locked <0x1f3> (a mutilthread.thread.synchronize.Person)
 at mutilthread.thread.synchronize.T_001$1.run(T_001.java:45)
 at java.lang.Thread.run(Thread.java:748)
 * 2-2) 锁定静态变量, 锁定的就是指定的静态变量
 静态变量因为只有一个, 所以能拿来作为一把锁
 "Thread-0@486" prio=5 tid=0xe nid=NA runnable
 java.lang.Thread.State: RUNNABLE
 at mutilthread.thread.synchronize.Person.c(T_001.java:104)
 - locked <0x1f6> (a java.lang.Object)
 at mutilthread.thread.synchronize.T_001$1.run(T_001.java:60)
 at java.lang.Thread.run(Thread.java:748)
 * 2-3) 不推荐使用String,Integer...基本数据类型作为锁对象, 否则会带来不必要的麻烦
 *
 */
public class T_001 {

    public static void main(String[] args) {
        Person person = new Person();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                person.h();
            }
        }).start();*/

      /* new Thread(new Runnable() {
            @Override
            public void run() {
                Person.t();
            }
        }).start();*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                person.b();
            }
        }).start();*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                person.c();
            }
        }).start();*/

    }
}

class Person{

    private int count=0;
    private static int count2 = 0;
    private static Object obj = new Object();

    //修饰普通方法
    public synchronized void h(){
        count ++ ;
        System.out.println(Thread.currentThread().getName()+"-count:"+count);
    }

    //修饰代码块
    public void b(){
        synchronized(this) {
            count ++ ;
            System.out.println(Thread.currentThread().getName()+"-count:"+count);
        }
    }

    public void c(){
        synchronized(obj) {
            count ++ ;
            System.out.println(Thread.currentThread().getName()+"-count:"+count);
        }
    }

    // 修饰静态方法
    public synchronized static void t(){
        count2 ++ ;
        System.out.println(Thread.currentThread().getName()+"-count:"+count2);
    }
}
