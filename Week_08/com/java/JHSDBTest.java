/**
 * @author nanbeiyang
 * @version JHSDBTest.java, v 0.1 2020/8/28 3:15 下午  Exp $$
 * @name
 */
public class JHSDBTest {
    private static ObjectHandler staticHandler = new ObjectHandler();
    private ObjectHandler instanceObject = new ObjectHandler();
    public void foo() {
        ObjectHandler localObject = new ObjectHandler();
        ObjectHandler localObject2 = new ObjectHandler();

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JHSDBTest test = new JHSDBTest();
        test.foo();
    }
    private static class ObjectHandler{}

}
