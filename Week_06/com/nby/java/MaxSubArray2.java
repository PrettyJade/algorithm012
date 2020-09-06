/**
 * @author nanbeiyang
 * @version MaxSubArray2.java, v 0.1 2020/8/29 5:22 下午  Exp $$
 * @name
 */
public class MaxSubArray2 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(sum, 0) + num;

            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray2 array2 = new MaxSubArray2();
        int[] a = {-2,1,-3,4,-1,2,1,-5};
        System.out.println(array2.maxSubArray(a));
    }

    public MaxSubArray2() {
    }
}
