/**
 * @author nanbeiyang
 * @version MaxSumSubmatrix.java, v 0.1 2020/8/29 5:39 下午  Exp $$
 * @name
 */
public class MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length, max = 0;
        for (int l = 0; l < m; l++) {
            int[] rows = new int[n];
            for (int i = l; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rows[j] += matrix[j][i];
                }
                max = Math.max(max, dpMax(rows, k));
                if (max == k) return k;
            }
        }

        return max;
    }

    private int dpMax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                // 尽量提前
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }


}
