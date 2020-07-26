/**
 * @author nanbeiyang
 * @version MyPow.java, v 0.1 2020/7/26 11:52 上午  Exp $$
 * @name
 */
public class MyPow {

    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? pow(x, N) : 1 / pow(x, -N);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double pow = pow(x, n / 2);
        return n % 2 == 0 ? pow * pow : pow * pow * x;
    }

    public static void main(String[] args) {
        double x = 1D;
        int n = -2147483648;
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(x, n));
    }

}
