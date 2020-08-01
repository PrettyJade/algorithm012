/**
 * @author nanbeiyang
 * @version IsPerfectSquare.java, v 0.1 2020/8/1 7:26 下午  Exp $$
 * @name
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long)mid * mid == num) {
                return true;
            } else if ((long)mid * mid > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }


}
