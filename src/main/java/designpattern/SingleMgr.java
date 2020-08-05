package designpattern;

/**
 * 关键几步:
 * 1. double check 双重检查singleMgr是否为空 避免并发问题, 并且性能最好
 * 2. 加锁 synchronized, 避免并发问题
 * 3. 用volatile修复, 确保不会发生指令重排序
 */
public class SingleMgr {
    private volatile static SingleMgr singleMgr;

    private SingleMgr(){}

    public SingleMgr getInstance(){
        if(singleMgr == null){
            synchronized (SingleMgr.class){
                if(singleMgr==null){
                    singleMgr = new SingleMgr();
                }
            }
        }
        return singleMgr;
    }
}
