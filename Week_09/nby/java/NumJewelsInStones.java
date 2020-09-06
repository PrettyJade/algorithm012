/**
 * @author nanbeiyang
 * @version NumJewelsInStones.java, v 0.1 2020/9/5 1:47 下午  Exp $$
 * @name
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if (s == j) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
}
