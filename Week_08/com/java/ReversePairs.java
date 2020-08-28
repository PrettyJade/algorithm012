/**
 * @author nanbeiyang
 * @version ReversePairs.java, v 0.1 2020/8/28 12:02 下午  Exp $$
 * @name
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        // 这道题可以用归并排序，应为归并排序，采用的是分治的方法，
        // 所以一开始是单个单个比较，后面再两两比较，依次递增，
        // 在这个过程中，我们就可以求解出大于两倍数的
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        int pairNum = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        pairNum += merge(nums, start, end, mid);
        return pairNum;
    }

    private int merge(int[] nums, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int i = start, p = start, j = mid + 1, k = 0, counter = 0;
        while (j <= end) {
            while (p <= mid && nums[p] / 2d <= (nums[j])) p ++;
            counter += mid - p + 1;
            while (i <= mid && nums[i] <= nums[j]) temp[k ++] = nums[i ++];
            temp[k ++] = nums[j ++];
        }
        while (i <= mid) temp[k ++] = nums[i ++];
        System.arraycopy(temp, 0, nums, start, temp.length);
        return counter;
    }


    public static void main(String[] args) {
        ReversePairs pairs = new ReversePairs();
        int[] a = {143,-154,-338,-269,287,214,313,165,-364,-22,-212,328,-432};
        pairs.reversePairs(a);
    }
}
