package designpattern.visit;

/**
 * 元素，每个元素都可以接受访问者
 */
public interface Element {
    void accept(Vistor vistor);
}
