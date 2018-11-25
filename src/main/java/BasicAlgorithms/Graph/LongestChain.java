package BasicAlgorithms.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;


/*


StringChain
You are given a library with n words (w[0], w[1], ..., w[n - 1]). You
choose a word from it, and in each step, remove one letter from this
word only if doing so yields a another word in the library. What is the
longest possible chain of these removal steps?
Constraints:
1 ≤ n ≤ 50000
1 ≤ the length of each string in w ≤ 50
Each string composed of lowercase ascii letters only.
Input Format:
Complete the function "longest_chain" which contains an array of
strings "w" as its argument.
Output Format:
Return a single integer that represents the length of the longest chain of
character removals possible.
Sample Input #00:
6
a
b
ba
bca
bda
bdca
Sample Output #00:
4
 */
/**
 * Created by hadoop on 16/10/17.
 */
public class LongestChain {
    public static int FindLongestChain(String[] words) {
        int len = words.length;
        HashSet<String> set = new HashSet<>();
        for(String word: words){
            set.add(word);
        }
        int res = 0;
        for(String s:words){
            res = Math.max(res,BFS(s,set));
        }
        return res;
    }

    private static int BFS(String s, HashSet<String> set) {
        Queue<String> queue = new ArrayDeque<>();
        HashMap<String,Integer> dis = new HashMap<>();
        queue.add(s);
        dis.put(s,0);
        while (!queue.isEmpty()){
            String polled = queue.poll();
            for(int i=0;i<polled.length();i++){
                StringBuilder sb = new StringBuilder(polled);
                sb.deleteCharAt(i);
                String temp = sb.toString();
                if(set.contains(temp)){
                    if(temp.length() == 1){
                        // this is destination in BFS algorithm
                        // usually we check it once we poll frmo the queue
                        // and then check its distnace
                        // before inserting in queue as well
                        // we can do this
                        return dis.get(temp)+1;
                    }
                    dis.put(temp,dis.get(polled)+1);
                    queue.add(temp);
                }
            }
        }
        // if unable to find
        return -1;
    }
}