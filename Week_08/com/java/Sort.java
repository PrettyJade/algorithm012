/**
 * @author nanbeiyang
 * @version QuickSort.java, v 0.1 2020/8/27 4:05 下午  Exp $$
 * @name
 */
public class Sort {

    public void quickSort(int[] arr) {
        // 快排的中心思想是，随便找一个数（一般最后面一个数），将比他小的数依次放在数组的最左边，
        // 遍历一遍后，就能得到这个数的最左边都是比他小的，最右边是比他大的
        // 然后重复对他左右两边的数组进行相同的操作就可以得出拍好序的数组
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end - 1);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(arr, i, start ++);
            }
        }
        swap(arr, end, start);
        return start;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void mergeSort(int[] arr) {
        // 归并排序是采用了分支法的排序算法，将两个有序的子序列合并，得到一个完全有序的序列
        mergeSort(arr, 0 , arr.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k ++] = arr[i] <= arr[j] ? arr[i ++] : arr[j ++];
        }
        while (i <= mid) temp[k ++] = arr[i ++];
        while (j <= end) temp[k ++] = arr[j ++];

        for (int p = 0; p < temp.length; p++) {
            arr[start + p] = temp[p];
        }
    }


    public void heapSort(int[] array) {
        // 堆排序，通过堆的特性，节点的值比自节点小于或者大于
        int length  = array.length;
        // 第一次遍历，将数组变成一个大顶堆
        for (int i = length / 2 - 1; i >= 0; i --) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i --) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int length, int i) {
        int left = i * 2  + 1, right = i * 2  + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, length, largest);
        }
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {7,1,3,19,4,5,1,2};
        sort.heapSort(a);
        System.out.println(a);
    }

}
