/**
 * @author nanbeiyang
 * @version MyAtoi.java, v 0.1 2020/9/5 2:02 下午  Exp $$
 * @name
 */
public class MyAtoi {
    public int myAtoi(String str) {
        int ans = -0;
        Boolean isPos = null;
        for (char c : str.toCharArray()) {
            if (isPos != null) {
                if ( c >= '0' && c <= '9') {
                    int cNum = c - 48;
                    if (isPos) {
                        if (ans > Integer.MAX_VALUE / 10  || (ans == Integer.MAX_VALUE / 10 && cNum > 7) ) {
                            return Integer.MAX_VALUE;
                        }
                        ans = ans * 10 + cNum;
                    } else {
                        if (ans < Integer.MIN_VALUE / 10  || (ans == Integer.MIN_VALUE / 10 && cNum > 8) ) {
                            return Integer.MIN_VALUE;
                        }
                        ans = ans * 10 - cNum;
                    }
                } else {
                    return ans;
                }
            } else {
                if (c == '-') {
                    isPos = false;
                } else if (c >= '0' && c <= '9') {
                    isPos = true;
                    ans = c - 48;
                } else if (c == '+') {
                    isPos = true;
                } else if (c != ' ') {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = -0 + 1;
        System.out.println(a);
        System.out.println((int)'+');
        System.out.println((int)'0');
        System.out.println((int)'9');
    }
}
