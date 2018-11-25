package BasicAlgorithms.Array;

/**
 * Created by hadoop on 12/10/17.
 */
public class shortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                index1 = i;
            }
            if(words[i].equals(word2)){
                index2 = i;
            }
            if(index1!=-1 && index2!=-1){
                dist = Math.min(dist,Math.abs(index1-index2));
            }
        }
        return dist;
    }
}