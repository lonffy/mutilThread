package designpattern.proxy;

public class SubjectProxy implements Subject{
    private Subject subject;
    public SubjectProxy(Subject subject){
        this.subject = subject;
    }
    private SubjectProxy(){}

    @Override
    public void req() {
        subject.req();
    }
}

