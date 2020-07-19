/**
 * @author nanbeiyang
 * @version NthUglyNumber.java, v 0.1 2020/7/19 3:00 下午  Exp $$
 * @name
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        // 丑数是2的a次方*3的b次方*5的c次方，所以这道题，主要核心是维护a，b，c三个指针，取依次递增
        // 就可以获取到所有的丑数
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i ++) {
            int n2 = 2 * res[a], n3 = 3 * res[b], n5 = 5 * res[c];
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) a ++;
            if (res[i] == n3) b ++;
            if (res[i] == n5) c ++;
        }

        return res[n - 1];
    }
}
