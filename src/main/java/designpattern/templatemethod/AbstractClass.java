package designpattern.templatemethod;

abstract class AbstractClass {
    /**
     * 关键是这个模板方法，定义好一系列的固定动作，其中抽象方法用于扩展
     * @param type
     */
    public void templateMethod(int type){
        specificMethod();
        extendmethod1();
        extendmethod2();
        if(type == 2){
            hookMethod();
        }
    }

    /**
     * 默认有实现逻辑的方法，当然也可以自行扩展
     */
    void specificMethod(){
        System.out.println("specificMethod...");
    }

    /**
     * 可扩展
     */
    abstract void extendmethod1();
    abstract void extendmethod2();
    abstract void hookMethod();
}
