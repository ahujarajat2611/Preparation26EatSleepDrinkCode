package DSA.Dp;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by hadoop on 19/2/18.
 */
public class CanIWin {
    private boolean canIWinBruteForce(int total, int[] state) {
        if (total <= 0)
            return false;
        for (int i = 1; i < state.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                if (!canIWinBruteForce(total - i, state)) {
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        return false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        HashMap<String, Boolean> map = new LinkedHashMap<>();
        boolean[] state = new boolean[maxChoosableInteger + 1];
        boolean result = canIWin(desiredTotal, state, map);
        System.out.println(map);
        return result;
    }
    private boolean canIWin(int total, boolean[] state, HashMap<String, Boolean> hashMap) {
        if (total <= 0)
            return false;

        String curr = getKey(state);

        if (hashMap.containsKey(curr))
            return hashMap.get(curr);

        for (int i = 1; i < state.length; i++) {
            if (!state[i]) {
                state[i] = true;
                if (!canIWin(total - i, state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i] = false;
                    return true;
                }
                state[i] = false;
            }
        }
        hashMap.put(curr, false);
        return false;
    }

    private String getKey(boolean state[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < state.length; i++) {
            sb.append(state[i] ? 1 : 0);
        }
        return sb.toString();
    }
    private boolean canIWin2(int total, int[] state, HashMap<String, Boolean> hashMap) {
        if (total <= 0)
            return false;

        String curr = getKey2(state);

        if (hashMap.containsKey(curr))
            return hashMap.get(curr);

        for (int i = 1; i < state.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                if (!canIWin2(total - i, state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        hashMap.put(curr, false);
        return false;
    }

    private String getKey2(int state[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < state.length; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        CanIWin obj = new CanIWin();
        boolean result = false;
        result = obj.canIWin(5, 7);
        System.out.println(result);

        result = obj.canIWin(10, 11);
        System.out.println(result);

    }
}
