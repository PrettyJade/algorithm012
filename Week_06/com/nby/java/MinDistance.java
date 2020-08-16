/**
 * @author nanbeiyang
 * @version MinDistance.java, v 0.1 2020/8/14 8:59 下午  Exp $$
 * @name
 */
public class MinDistance {
    /**
     * 这道题可以用动态规划，从题解中我们可以看出
     * work1[i] == work2[j] 那么比较work[i+1] 和work2[j+1]的编辑的最小操作数
     * 如果两者不相同，那就有三种方式可以进行编辑
     * 1.插入 在work1[i + 1] = work2[j] ——> work1[i] 和 work2[j - 1]的最小编辑数
     * 2.删除 那就直接比较 work[i - 1] 和 work2[j]的最小编辑数
     * 3.替换 那就更两者相等一样，比较的是 work[i-1] 和 work2[j - 1]
     * 确定存储数组 dp[i][j] : i 为第work1中的第i个字符，j 为work2中的第j个字符，两个的值是work1中的从0-i个字符变成成为work2中0-j的最小编辑数
     * 确定dp方程
     * dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j])
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        // 当work1 == 0 时，就是添加n个字母变成work2
        // 当work2 == 0 时，就是删除work1的所有字母
        int n1 = word1.length(), n2 = word2.length();
        if (n1 == 0 || n2 == 0) {
            return Math.max(n1, n2);
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 需要进行边界初始化，把dp[0][0] 当成 work1和work2的两个空字符
        for (int i = 0; i <= n1; i ++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i ++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n1; i ++) {
            for (int j = 1; j <= n2; j ++) {
                if (word1.charAt(i -1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[n1][n2];
    }
}
