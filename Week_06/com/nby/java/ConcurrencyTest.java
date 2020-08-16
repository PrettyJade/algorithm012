/**
 * @author nanbeiyang
 * @version ConcurrencyTest.java, v 0.1 2020/8/9 12:51 上午  Exp $$
 * @name
 */
public class ConcurrencyTest {
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
    static long count = 100000;
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i ++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i ++) {
            b--;
        }
        String a = "";
        a.intern();
        thread.join();
        System.out.println("concurrency:" + (System.currentTimeMillis() - start));
        Thread.sleep(count);
    }

    private static void serial() {

        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i ++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i ++) {
            b--;
        }
        System.out.println("concurrency:" + (System.currentTimeMillis() - start));
    }
}
