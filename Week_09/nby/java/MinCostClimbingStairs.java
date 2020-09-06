/**
 * @author nanbeiyang
 * @version MinCostClimbingStairs.java, v 0.1 2020/9/2 1:25 下午  Exp $$
 * @name
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs2(int[] cost) {
        // dp[i] = Math.min(dp[i - 1] + cost(i - 1), dp[i - 2) + cost(i - 2));
        int n = cost.length + 1;
        if (n == 2) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n - 1];
    }
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] = Math.min(dp[i - 1] + cost(i - 1), dp[i - 2) + cost(i - 2));
        int n = cost.length + 1;
        if (n == 2) {
            return 0;
        }
        int f1 = 0, f2 = 0;
        for (int i = 2; i < n; i++) {
            int temp = f2;
            f2 = Math.min(f2 + cost[i - 1], f1 + cost[i - 2]);
            f1 = temp;
        }
        return f2;
    }
}
