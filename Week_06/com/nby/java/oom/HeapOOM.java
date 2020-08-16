package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version HeapOOM.java, v 0.1 2020/8/10 10:44 下午  Exp $$
 * @name
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }


}
