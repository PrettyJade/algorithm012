/**
 * @author nanbeiyang
 * @version ReverseOnlyLetters.java, v 0.1 2020/9/5 5:31 下午  Exp $$
 * @name
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] array = S.toCharArray();
        while (i < j) {
            while (i < j && !((array[i] >= 'a' && array[i] <= 'z')  || (array[i] >= 'A' && array[i] <= 'Z')))  {
                i ++;
            }
            while (i < j && !((array[j] >= 'a' && array[j] <= 'z')  || (array[j] >= 'A' && array[j] <= 'Z')))  {
                j --;
            }
            char temp = array[i];
            array[i ++] = array[j];
            array[j --] = temp;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        System.out.println((int)'Z');
        System.out.println((int)'a');
    }
}
