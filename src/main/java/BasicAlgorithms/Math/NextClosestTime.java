package BasicAlgorithms.Math;

/**
 * Created by hadoop on 25/1/18.
 */
/*
/**
 * LeetCode 681 - Next Closest Time
 * <p>
 * Brute-force
 * Pay attentions to the following:
 * <p>
 * 1) Don't forget the leading zero. That is, 1:33 should be printed as 01:33.
 * 2) The answer to (say) 22:22 is 22:22, which is 24 hours later.
 */

public class NextClosestTime {

    public String nextClosestTime(String time) {
        int[] cands = time.chars().filter(ch -> ch != ':').map(i -> i - '0').distinct().toArray();
        int minDiff = Integer.MAX_VALUE;
        String ans = null;
        int startTime = timeStringToMinutes(time);

        // get initial time and get initial digits to play with
        for (int h1 : cands)
            for (int h2 : cands) {
                int h = h1 * 10 + h2;
                if (h < 0 || h >= 24) continue;

                for (int m1 : cands)
                    for (int m2 : cands) {
                        int m = m1 * 10 + m2;
                        if (m < 0 || m >= 60) continue;

                        int endTime = 60 * h + m;
                        if (endTime <= startTime) {
                            endTime += 24 * 60;
                        }

                        if (endTime - startTime < minDiff) {
                            minDiff = endTime - startTime;
                            ans = String.format("%02d:%02d", h, m);
                        }
                    }
            }
        return ans;
    }
    int timeStringToMinutes(String time) {
        String h = time.split(":")[0];
        String m = time.split(":")[1];
        return Integer.parseInt(h) * 60 + Integer.parseInt(m);
    }
}
