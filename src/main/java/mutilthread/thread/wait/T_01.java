package mutilthread.thread.wait;

public class T_01 {
    public static void main(String[] args) {
        final T t = new T();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    t.h();
                }

            }
        });
    }
}