package Algorithms6hourTraining;
import java.util.*;

/**
 * Created by hadoop on 21/12/17.
 */
/*
 word matcher in dictionary problem it is
 dp [0] = 1
 dp=new int[word.length()+1]
 end-> 1 to s.length()
 dp[i] and substring(i,end)exists in dictionary

 sort dictionary based on length before we move to this function

 */
public class ConcatenateWords {


    boolean canFormWords(String word,Set<String> preWords){
        if(preWords.size() ==0){
            return false;
        }
        // addnig extra layer of 1
    int dp [] = new int[word.length()+1];
    dp[0] = 1;
    // initial value
    // here end loop for word starting from 1 and ending at alength
        // since substring required 1 aextra from index
        // i,j substrinr always i,j+1   .... end index exclusive it is thats why loop from end 1 to s.length()
    // could have used boolean to keep track
        // if it is possible to form word or not !!
        // thats much better technique !!

        for(int end = 1;end<=word.length();end++){
        dp[end] = Integer.MAX_VALUE;
        for(int i=0;i<end;i++){
            // also need to check if dp[i] also exists in n
            // also check is required to see if dp[i] can form word and i to end is there in dictionary!!
            // dp[i] denotes value till dp[i-1]
            if(preWords.contains(word.substring(i,end))){
                dp[end] = Math.min(dp[end],dp[i]+1);
            }
        }
    }
    return dp[word.length()]!=Integer.MAX_VALUE;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        // make sense to ssort by increainsg order of string length
        // then keep seeing each word and post that add to list of prewords
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (canFormWords(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println("".length());
    }
}
