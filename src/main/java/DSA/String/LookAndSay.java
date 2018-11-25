package DSA.String;

/**
 * Created by hadoop on 11/2/18.
 */
public class LookAndSay {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        String pre = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder res = new StringBuilder();
            char prev = pre.charAt(0);
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                char cur = pre.charAt(j);
                if (prev == cur) {
                    count++;
                } else {
                    res.append(count);
                    res.append(prev);
                    prev = cur;
                    count = 1;
                }
            }

            res.append(count);
            res.append(prev);
            pre = res.toString();
        }

        return pre;
    }
}
