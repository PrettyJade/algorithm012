import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nanbeiyang
 * @version Dispatch.java, v 0.1 2020/9/4 7:23 下午  Exp $$
 * @name
 */
public class Dispatch {
    static class QQ {}
    static class _360 {}
    static class Father {
        public void hardChoice(QQ qq) {

            System.out.println("Father choice qq");
        }
        public void hardChoice(_360 _3) {
            System.out.println("Father choice 360");
        }
    }
    static class Son extends Father {
        @Override
        public void hardChoice(QQ qq) {
            System.out.println("Son choice qq");
        }
        @Override
        public void hardChoice(_360 _3) {
            System.out.println("Son choice 360");
        }
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.stream().map(Integer::valueOf).collect(Collectors.toList());
        int c = 4, b = 4;
        System.out.println(c > b);
        for (String s : a) {
            Integer.valueOf(s);
        }


    }
}
