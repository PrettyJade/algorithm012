/**
 * @author nanbeiyang
 * @version AA.java, v 0.1 2020/9/3 5:02 下午  Exp $$
 * @name
 */
public class FileResolution implements ParentFile {
    static ParentFile resolution;
    public FileResolution () {
    }
    public long test2(int k, int j) {
        int a =  2;
        long b = 3;
        long c = 4;
        test('a');
        System.out.println(a + b);
        return 1000;
    }

    public int test(int a) {
        return 0;
    }
    public static int test(char a) {
        System.out.println(a);
        return 0;
    }

    @Override
    public void test() {

    }

    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {

    }

    static class Sub extends Parent  {
        public static int B = 4;
    }

    public static void main(String[] args) {
        FileResolution fileResolution = new FileResolution();
        System.out.println(Sub.A);
    }


}
