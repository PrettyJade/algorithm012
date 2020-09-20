package classloader;

/**
 * @author nanbeiyang
 * @version HotSwapClassLoader.java, v 0.1 2020/9/8 4:39 下午  Exp $$
 * @name
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }


}
