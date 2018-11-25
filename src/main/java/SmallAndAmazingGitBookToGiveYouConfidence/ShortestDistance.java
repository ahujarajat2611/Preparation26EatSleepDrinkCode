package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class ShortestDistance {
    public int shortestDistance(String []words,String word1,String word2){
        int index1 = -1;
        int index2 = -1;
        int mindiff = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equalsIgnoreCase(word1)){
                if(index2!=-1 && word1.equals(word2)){
                    if(mindiff >Math.abs(index1-index2)){
                        mindiff = Math.abs(index1-index2);
                    }
                }
                index1 =i;
            }

            if(words[i].equalsIgnoreCase(word2)){
                index2 = i;
            }

            if(index1!=-1 && index2!=-1){
               if(mindiff >Math.abs(index1-index2)){
                   mindiff = Math.abs(index1-index2);
               }
            }
        }
        return mindiff;
    }
}
