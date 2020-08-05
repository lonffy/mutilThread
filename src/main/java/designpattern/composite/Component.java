package designpattern.composite;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;

public interface Component {
    public void add(Component component);
    public void remove(Component component);
    public void operation();
}
