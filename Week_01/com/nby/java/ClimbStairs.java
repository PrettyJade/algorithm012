/**
 * @author nanbeiyang
 * @version ClimbStairs.java, v 0.1 2020/7/20 9:11 下午  Exp $$
 * @name
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        // 通过观察，我们可以知道一个公式，f(n) = f(n-1) + f(n-2)
        if (n < 3) {
            return n;
        }
        int f1 = 1, f2 = 2;
        // 不断的循环，通过f1 + f2获取到下一个值
        while (n > 2) {
            int f0 = f2;
            f2 = f1 + f2;
            f1 = f0;
            n --;
        }
        return f2;
    }
}
