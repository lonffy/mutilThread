package mutilthread.thread.wait;

public class T {
    static int count=0;

    void h(){
        count++;
        System.out.println(Thread.currentThread().getName()+"-count:"+count);
    }
}
