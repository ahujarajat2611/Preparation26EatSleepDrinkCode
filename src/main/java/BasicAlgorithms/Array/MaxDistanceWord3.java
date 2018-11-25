package BasicAlgorithms.Array;

/**
 * Created by hadoop on 12/10/17.
 */
public class MaxDistanceWord3 {
    public static void main(String args[]){
        String []words = {"a","a","b","b"};
        String word1="b";
        String word2="b";

        System.out.println(shortestdistance(words,word1,word2));
        System.out.println(shortestWordDistance(words,word1,word2));
    }

    public static int shortestdistance(String[] words, String word1, String word2){
        int index1 = -1;
        int index2 = -1;
        int mindis = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                index1 = i;
            }
            if(words[i].equals(word2)){
                if(word1.equals(word2)){
                    index1 = index2;
                    System.out.println("index1"+index1);
                }
                index2 = i;
                System.out.println("index2"+index2);
            }
            System.out.println("index1"+index1);
            System.out.println("index2"+index2);
            System.out.println("diff"+Math.abs(index1-index2));
            mindis= Math.min(mindis,Math.abs(index1-index2));
        }
        return mindis;
    }
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = words.length;
        int index1 = words.length;
        int index2 = -words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    index1 = index2;
                    System.out.println("index1"+index1);
                }
                index2 = i;
                System.out.println("index2"+index2);
            }
            if(index1!=-1 && index2!=-1) {
                dist = Math.min(dist, Math.abs(index2 - index1));
            }
        }
        return dist;
    }
}
