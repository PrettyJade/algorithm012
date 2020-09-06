/**
 * @author nanbeiyang
 * @version ValidPalindrome.java, v 0.1 2020/9/5 6:52 下午  Exp $$
 * @name
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int low = -1, high = s.length();
        while (++low < --high) {
            if (s.charAt(low) != s.charAt(high)) {
                return isPalindrome(s, low - 1, high) || isPalindrome(s, low, high + 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (++ low < --  high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
        }
        return true;
    }
}
