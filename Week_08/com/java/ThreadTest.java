import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nanbeiyang
 * @version ThreadTest.java, v 0.1 2020/8/28 5:59 下午  Exp $$
 * @name
 */
public class ThreadTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        createBusyThread();
        reader.readLine();
        Object object = new Object();
        createLockThread(object);
    }

    private static void createLockThread(Object object) {
        new Thread(() -> {
            synchronized (object)  {
                try {
                    object.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "createLockThread").start();
    }

    private static void createBusyThread() {
        new Thread(() -> {
            while (true) ;
        }, "createBusyThread").start();
    }
}