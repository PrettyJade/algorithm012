/**
 * @author nanbeiyang
 * @version SearchMatrix.java, v 0.1 2020/8/1 8:59 下午  Exp $$
 * @name
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = n * m - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int x = mid / m, y = mid % m;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }

}
