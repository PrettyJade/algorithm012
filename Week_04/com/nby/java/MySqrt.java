/**
 * @author nanbeiyang
 * @version MySqrt.java, v 0.1 2020/8/1 2:19 下午  Exp $$
 * @name
 */
public class MySqrt {
    public int mySqrt(int x) {
        // 由于x平分根的整数部分ans是满足k^2<=X的k的最大值，因此我们对k进行二分查找，是可以得倒答案的
        // 他的下界是0，上界粗略的设置为x，在二分查找的每一步中，我们只需要比较中间元素mid的平分与x的大小关系，并通过比较结果调整上下界范围
        int l = 0, r = x, mid, ans = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double c = x, x0 = x, xi;
        while (true) {
            xi = 0.5 * (x0 + c / x0);
            if (Math.abs(x0 - xi) <= 1e-7) {
                return (int)xi;
            }
            x0 = xi;
        }
    }

    public static void main(String[] args) {

        MySqrt mySqrt = new MySqrt();
        mySqrt.mySqrt(2147395599);
    }

}
