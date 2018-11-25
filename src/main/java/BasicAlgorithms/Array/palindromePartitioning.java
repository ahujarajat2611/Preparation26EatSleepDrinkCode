package BasicAlgorithms.Array;
import java.util.*;

public class palindromePartitioning {
    public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return res;
		boolean[][] dict = getDict(s);
		helper(s, 0, s.length(), new ArrayList<String>(), res, dict);
		return res;
	}

	private void helper(String s, int start, int end, ArrayList<String> item,
			List<List<String>> res, boolean[][] dict) {
		if (start == end) {
			res.add(new ArrayList<String>(item)); //此处易错
			return;
		}
		for (int i = start; i < end; i++) {
			if (dict[start][i]) {
				item.add(s.substring(start, i+1));
				helper(s, i + 1, end, item, res, dict);
				item.remove(item.size() - 1);
			}
		}
	}

	private boolean[][] getDict(String s) {
		boolean[][] dict = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i <= 2)
						dict[i][j] = true;
					else
						dict[i][j] = dict[i + 1][j - 1];
				}
			}
		}
		return dict;
	}
	
	//Method 2: 不用dict的方法
	public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return res;
        helper (s, 0, new ArrayList<String>(), res);
        return res;
    }
    private void helper(String s, int start, List<String> list, List<List<String>> res) {
        if (start > s.length()-1) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalidrom(s, start, i)) {
                list.add(s.substring(start, i+1));
                helper(s, i+1, list, res);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalidrom(String s, int l, int r) {
        while(l<=r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
    
    //对方法二进行简单修改，加入dp
    public List<List<String>> partition3(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return res;
        boolean[][] dp = new boolean[s.length()][s.length()];
        helper (s, 0, new ArrayList<String>(), res, dp);
        return res;
    }
    private void helper(String s, int start, List<String> list, List<List<String>> res, boolean[][] dp) {
        if (start > s.length()-1) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalidrom(s, start, i, dp)) {
                list.add(s.substring(start, i+1));
                helper(s, i+1, list, res);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalidrom(String s, int l, int r, boolean[][] dp) {
       if (s.charAt(l) == s.charAt(r) && (r-l<2 || dp[l+1][r-1]))
    	   dp[l][r] = true;
       return dp[l][r];
    }
}
