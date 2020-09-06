/**
 * @author nanbeiyang
 * @version CheckInclusion.java, v 0.1 2020/9/6 8:38 下午  Exp $$
 * @name
 */
public class CheckInclusion {
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i]) {
                count++;
            }
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26) {
                return true;
            }
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 97]++;
            s2map[s2.charAt(i) - 97]++;
        }
        int count = 0;
        for (int i = 0; i < s1map.length; i++) {
            if (s1map[i] == s2map[i]) {
                count++;
            }
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int l = s2.charAt(i) - 97, r = s2.charAt(i + s1.length()) - 97;
            if (count == 26) {
                return true;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
        }

        return count == 26;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] mp = new int[123];
        for (char c : s1.toCharArray()) {
            mp[c] ++;
        }
        int l = 0, r = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r ++);
            mp[c] --;
            //  若是map < 0 ,就需要对之前减去的数字重新加回去
            while (l < r && mp[c] < 0) {
                mp[s2.charAt(l ++)] ++;
            }
            if (r - l == s1.length()) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println((int) 'z');
    }

}
