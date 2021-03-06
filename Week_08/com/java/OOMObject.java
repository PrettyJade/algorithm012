import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version OOMObject.java, v 0.1 2020/8/28 4:58 下午  Exp $$
 * @name
 */
public class OOMObject {
    private byte[] placeholder = new byte[64 * 1024];

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

}
