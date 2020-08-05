package designpattern.facade;

public class SystemFacade {
    System01 system01 = new System01();
    System02 system02 = new System02();
    System03 system03 = new System03();

    public void excute(){
        system01.excute();
        system02.excute();
        system03.excute();
    }
}
