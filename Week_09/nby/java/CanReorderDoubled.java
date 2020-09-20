import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.FutureTask;

/**
 * @author nanbeiyang
 * @version CanReorderDoubled.java, v 0.1 2020/9/7 10:16 下午  Exp $$
 * @name
 */
public class CanReorderDoubled {
    public boolean canReorderDoubled(int[] A) {
        Character
        FutureTask<String> a = new FutureTask<>();
        a.run();
        HashMap map = new HashMap();
        map.putIfAbsent()
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : A) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        // treemap 对数组进行了排序,因为进行了排序，所以有一下特性
        // 当x < 0 ，它的对应数值是 x / 2
        // 所以，当x< 0,且x不是偶数时，结果肯定为false
        // 当x > 0, 他的对应数值是 x * 2
        //  且当x的数量大于对应数值的时候，也是false
        for (Integer key : treeMap.keySet()) {
            // 这里为0 识别前面对应的x给消耗掉了
            if (treeMap.get(key) == 0) continue;
            int want = key < 0 ? key / 2 : key * 2;
            if (key < 0 && key % 2 != 0 || treeMap.get(key) > treeMap.getOrDefault(want, 0)) {
                return false;
            }
            treeMap.put(want, treeMap.get(want) - treeMap.get(key));
        }
        return true;
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public int trap(int[] height) {
        Socket
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int area = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    //蓄水
                    area += (leftMax - height[left]);
                }
                left ++;
            }  else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    area += (rightMax - height[right]);
                }
                right --;
            }
        }
        return area;
    }
}
