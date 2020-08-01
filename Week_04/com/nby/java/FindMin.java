/**
 * @author nanbeiyang
 * @version FindMin.java, v 0.1 2020/8/1 9:14 下午  Exp $$
 * @name
 */
public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0, j = nums.length - 1;
        if (nums[i] < nums[j]) {
            return nums[i];
        }
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[0] < nums[mid]) {
                i = mid + 1;
            } else {
                i = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] a = {1, 2};
        System.out.println(findMin.findMin(a));
    }

}
