package classloader;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author nanbeiyang
 * @version Remote.java, v 0.1 2020/9/8 6:34 下午  Exp $$
 * @name
 */
public class Remote {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("/Users/nanbeiyang/Documents/qichechaoren/project/algorithm012/out/production/algorithm012/classloader/TestClass.class");
        byte[] b = new byte[is.available()];

        is.read(b);
        is.close();

        System.out.println(JavaClassExecuter.execute(b));

    }
}
