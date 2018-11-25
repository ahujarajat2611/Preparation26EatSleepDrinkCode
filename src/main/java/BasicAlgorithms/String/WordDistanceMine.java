package BasicAlgorithms.String;

/**
 * Created by hadoop on 4/3/18.
 */
public class WordDistanceMine {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int previndex1=-1;
        int previndex2 =-1;
        int index1=-1;
        int index2=-1;


        int diff = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){

            if(words[i].equalsIgnoreCase(word1)){
                previndex1 = index1;
                index1 = i;
            }

            if(words[i].equalsIgnoreCase(word2)){
                previndex2 = index2;
                index2 = i;
            }

            if(!word1.equalsIgnoreCase(word2) && index1!=-1 && index2!=-1){
                diff = Math.min(diff,Math.abs(index1-index2));
            }

            if(word1.equalsIgnoreCase(word2) && previndex1!=-1 && index1!=-1){
                // System.out.println("ere");
                diff = Math.min(diff,Math.abs(previndex1-index1));
            }
        }
        return diff;
    }
}
