/**
 * @author nanbeiyang
 * @version IsPalindrome.java, v 0.1 2020/9/5 6:31 下午  Exp $$
 * @name
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i ++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j --;
            if (Character.toLowerCase(s.charAt(i ++)) != Character.toLowerCase(s.charAt(j --))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome  palindrome = new IsPalindrome();
        palindrome.isPalindrome("A man, a plan, a canal: Panama");
    }
}
