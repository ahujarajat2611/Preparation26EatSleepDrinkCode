package BasicAlgorithms.Array;
import java.util.*;
/**
 * Created by hadoop on 25/12/17.
 */
public class FindMinDiffBetweenTime {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> a = new ArrayList<>(timePoints.size() + 1);
        for (String s : timePoints)
            a.add(60 * Integer.parseInt(s.split(":")[0]) + Integer.parseInt(s.split(":")[1]));
        Collections.sort(a);
        a.add(a.get(0));

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            int diff = Math.abs(a.get(i) - a.get(i - 1));
            ans = Math.min(ans, Math.min(diff, 24 * 60 - diff));
        }
        return ans;
    }
    public int findMinDifferenceMine(List<String> timePoints) {
        List<Integer> a = new ArrayList<>(timePoints.size() + 1);
        for (String s : timePoints)
            a.add(60 * Integer.parseInt(s.split(":")[0]) + Integer.parseInt(s.split(":")[1]));
        Collections.sort(a);
        //a.add(a.get(0));
        //  System.out.println(a.get(a.size()-1));
        int ans1 = Math.abs(a.get(a.size()-1)-a.get(0));
        int ans2 = Math.abs(a.get(a.size()-1)-(24*60 + a.get(0)));
        //System.out.println(ans1);
        //System.out.println(ans2);
        int ans = Math.min(ans1,ans2);
        //int ans = Integer.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            int diff = Math.abs(a.get(i) - a.get(i - 1));
            ans = Math.min(ans,diff);
        }
        return ans;
    }
}
