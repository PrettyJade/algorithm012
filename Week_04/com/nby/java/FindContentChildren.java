import java.util.Arrays;

/**
 * @author nanbeiyang
 * @version FindContentChildren.java, v 0.1 2020/7/29 3:23 下午  Exp $$
 * @name
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j ++]) {
                i ++;
            }
        }
        return i;
    }
}
