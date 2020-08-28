import java.util.HashMap;
import java.util.Map;

/**
 * @author nanbeiyang
 * @version RelativeSortArray.java, v 0.1 2020/8/27 6:51 下午  Exp $$
 * @name
 */
public class RelativeSortArray {
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int n = arr1.length - 1;
        int current = 0;
        if (n < 2) {
            return arr1;
        }
        if (arr2.length != 0) {
            current = n;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr2) {
                map.put(num, 0);
            }

            for (int i = n; i >= 0; i--) {
                if (map.containsKey(arr1[i])) {
                    map.put(arr1[i], map.get(arr1[i]) + 1);
                } else {
                    swap(arr1, i, current --);
                }
            }
            sortBy2(arr1, arr2, map);
            current ++;
        }
        mergeSort(arr1, current, n);
        return arr1;
    }

    private void sortBy2(int[] arr1, int[] arr2, Map<Integer, Integer> map) {
        int k = 0;
        for (int arr : arr2) {
            int s = map.get(arr);
            while (s -- > 0) {
                arr1[k ++] = arr;
            }
        }
    }

    private void mergeSort(int[] arr1, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(arr1, start, mid);
        mergeSort(arr1, mid + 1, end);

        merge(arr1, start, end, mid);

    }

    private void merge(int[] arr, int start, int end, int mid) {
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            temp[k ++] = arr[i] <= arr[j] ? arr[i ++] : arr[j ++];
        }

        while (i <= mid) temp[k ++] = arr[i ++];
        while (j <= end) temp[k ++] = arr[j ++];

        System.arraycopy(temp, 0, arr, start, temp.length);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        for (int i : arr1) {
            temp[i] ++;
        }
        int k = 0;
        for (int i : arr2) {
            while (temp[i] -- > 0) {
                arr1[k ++] = i;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            while (temp[i] -- > 0) {
                arr1[k ++] = i;
            }
        }
        return arr1;
    }
}
