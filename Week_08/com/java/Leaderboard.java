/**
 * @author nanbeiyang
 * @version Leaderboard.java, v 0.1 2020/8/27 7:30 下午  Exp $$
 * @name
 */
public class Leaderboard {
    int[][] array = new int[10002][];
    int index = 0;

    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {
        int pos = search(playerId);
        int[] arrT = new int[2];
        arrT[0] = playerId;
        arrT[1] = score;
        if (pos != -1) {
            arrT[1] += array[pos][1];
        } else {
            pos = index++;
        }
        insert(arrT, pos);
    }

    private void insert(int[] arrT, int pos) {
        int i = pos;
        while (i > 0 && arrT[1] > array[i - 1][1]) {
            array[i] = array[i-- - 1];
        }
        array[i] = arrT;
    }

    private int search(int playerId) {
        for (int i = 0; i < index; i++) {
            if (array[i][0] == playerId) {
                return i;
            }
        }
        return -1;
    }

    public int top(int K) {
        int k = Math.min(K, index);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += array[i][1];
        }
        return sum;
    }

    public void reset(int playerId) {
        int pos = search(playerId);
        while (pos < index - 1){
            array[pos] = array[pos ++ + 1];
        }
        array[pos] = null;
    }
}
