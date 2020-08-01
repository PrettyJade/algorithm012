/**
 * @author nanbeiyang
 * @version Search.java, v 0.1 2020/8/1 8:08 下午  Exp $$
 * @name
 */
public class Search {
    public int search(int[] nums, int target) {
        // 这道题可以用二分查找，只是跳上下界的调节稍微更改一下
        // 有数据可以看出，如果中间值大于第一个值，那么左边数组是有序的，所有这个时候，如果目标值也大于第一个值，且小于中间，调整上界。
        // 反之亦然
        int i = 0, n = nums.length - 1, j = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[n] >= target && nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
    public int search(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[0] < nums[mid]) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] < nums[mid - 1]) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] a ={4,5,6,7,0,1,2};
        System.out.println(search.search(a));
    }

}
