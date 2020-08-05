package designpattern;

/**
 * 推荐用法, 简单易用
 * 关键点:
 * 1. 静态内部类static class LazyInitSingleMgr
 * 2. 静态内部类提前创建好对象, 要用的时候直接getInstance就可以了
 */
public class SingleMgr2 {

    private SingleMgr2(){}

    private static class LazyInitSingleMgr{
        public static SingleMgr2 singleMgr2 = new SingleMgr2();
    }

    public SingleMgr2 getInstance(){
        return LazyInitSingleMgr.singleMgr2;
    }
}
