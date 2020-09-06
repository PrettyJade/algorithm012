import java.util.HashMap;

/**
 * @author nanbeiyang
 * @version IsIsomorphic.java, v 0.1 2020/9/6 4:23 下午  Exp $$
 * @name
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        HashMap<Character, Character> map = new HashMap<Character, Character>();
//        map.containsValue()
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapS[c1] != mapT[c2]) {
                return false;
            }
            if (mapS[c1] == 0) {
                mapS[c1] = i + 1;
                mapT[c2] = i + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic c = new IsIsomorphic();
        c.isIsomorphic("abab","baba");
    }
}
