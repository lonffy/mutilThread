package designpattern.chainofresponsibility;

public class Chairman extends Leader{
    @Override
    void approve() {
        System.out.println("总裁审批完毕。。。");
        if(this.getNext()!=null){
            System.out.println("继续下一个审批>");
            this.getNext().approve();
        }else{
            System.out.println("审批完成");
        }
    }
}
