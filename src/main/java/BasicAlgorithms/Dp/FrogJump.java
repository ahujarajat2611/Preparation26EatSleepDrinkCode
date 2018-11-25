package BasicAlgorithms.Dp;
import java.util.*;

/**
 * Created by hadoop on 16/1/18.
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if (len <= 1) {
            return true;
        }
        if (len > 1 && stones[1] != 1) {
            return false;
        }
        Set<String> visited = new HashSet<>();
        return checkCanCross(1, 1, stones, visited);
    }

    private boolean checkCanCross(int start, int dist, int[] stones, Set<String> visited) {
        if (start >= stones.length - 1) {
            return true;
        }
        if (dist <= 0 || !visited.add(start + "," + dist)) {
            return false;
        }
        for (int i = start + 1; i < stones.length; i++) {
            int curr = stones[i] - stones[start];
            if (curr > dist + 1) {
                break;
            }
            if (curr == dist - 1 || curr == dist || curr == dist + 1) {
                if (checkCanCross(i, curr, stones, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
