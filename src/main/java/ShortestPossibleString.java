import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 27/12/17.
 */
public class ShortestPossibleString {

    public static void main(String[] args) {
        String[] array = {"dog", "postmaster", "mastermind"};
        List<String> path = new LinkedList<>();
        boolean[] visited = new boolean[array.length];
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(Integer.MAX_VALUE);
        String[] shortestString = new String[1];
        ShortestPossibleString shortestPossibleString = new ShortestPossibleString();
        shortestPossibleString.dfs(array,path,visited,atomicInteger,shortestString);
        System.out.println(shortestString[0]);
    }

    // Trying Out all possible options
    private void dfs(String[] array, List<String> path, boolean[] visited,AtomicInteger shortestLength,String []shortestString) {
        if (path.size() == array.length) {
            // we have considered all strings check its the shortest answer
            String localShortestString = mergeAdjacentString(path);
            if(localShortestString.length()<shortestLength.get()){
                shortestString[0] = localShortestString;
                shortestLength.set(shortestString[0].length());
            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i])
                continue;
            path.add(array[i]);
            visited[i] = true;
            dfs(array, path, visited,shortestLength,shortestString);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
    // Merging every adjacent Stirng possible to shorten the length

    private String mergeAdjacentString(List<String> path) {
        String ans = "";
        for (int i = 0; i < path.size(); i++) {
            ans = mergeHelper(ans, path.get(i));
        }
        return ans;
    }

    private String mergeHelper(String first, String second) {
        String sub1="";
        for(int i=second.length();i>=1;i--){
            String sub2 = second.substring(0,i);

            if(first.length()>=i) {
                sub1 = first.substring(first.length() - i);
            }
            if(sub2.equals(sub1)){
                return first+second.substring(i);
            }
        }
        return first+second;
    }
}
