import java.util.ArrayList;
import java.util.List;

/**
 * @author nanbeiyang
 * @version FindAnagrams.java, v 0.1 2020/9/5 5:55 下午  Exp $$
 * @name
 */
public class FindAnagrams {

    public List<Integer> findAnagrams2(String s, String p) {
        int[] count = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (char c : p.toCharArray()) {
            count[c - 97]++;
        }
        int j = 0, pCount = p.length();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && (j - i) < p.length()) {
                if (count[s.charAt(j++) - 97]-- > 0) {
                    pCount--;
                }
            }
            if (pCount == 0 && j - i < p.length()) {
                ans.add(i);
            }

            if (count[s.charAt(i) - 97]++ >= 0) pCount++;
        }
        return ans;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    public List<Integer> findAnagramsw2(String s, String p) {
        int[] letters = new int[26];
        for (int i = 0; i < p.length(); i++) {
            letters[p.charAt(i) - 'a']++;
        }
        int j = 0;
        int rem = p.length();
        List<Integer> result = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && j - i < p.length()) {
                if (letters[s.charAt(j++) - 'a']-- > 0) {
                    rem--;
                }
            }
            if (rem == 0 && j - i == p.length()) {
                result.add(i);
            }
            if (letters[s.charAt(i) - 'a']++ >= 0) {
                rem++;
            }
        }
        return result;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        int[] need = new int[124];
        int[] window = new int[124];
        for (char c : p.toCharArray()) {
            need[c]++;
        }
        int l = 0, r = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (r < s.length()) {
            char c = s.charAt(r ++);
            if (need[c] > 0) {
                window[c] ++;
                if (need[c] == window[c]) {
                    valid ++;
                }
            }
            while (r - l >= p.length()) {
                if (valid == p.length()) {
                    res.add(l);
                }
                char d = s.charAt(l ++);
                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }
        return res;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() <  p.length()) {
            return res;
        }
        int[] mp = new int[124];
        for (char c : p.toCharArray()) {
            mp[c] ++;
        }

        int r = 0, l = 0, valid = p.length();

        while (r < s.length()) {
            if (mp[s.charAt(r ++)] -- > 0) {
                valid --;
            }
            if (valid == 0) {
                res.add(l);
            }

            if (r - l == p.length()  && mp[s.charAt(l ++)] ++ >= 0) {
                valid ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAnagrams anagrams = new FindAnagrams();
        anagrams.findAnagrams("baa", "aa");
    }
}
