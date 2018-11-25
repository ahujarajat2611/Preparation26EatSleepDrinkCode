package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 14/9/17.
 */
public class WordAbbre {
    public static void main(String args[]){
        String word = "word";
        List<String> stringList = new ArrayList<>();
        int depth = 0;
        int count = 0;
        List<String> newStringList = new ArrayList<>();
        helper(word,depth,"",count,newStringList);
        System.out.println(newStringList);
        helperMineAgain(word,depth,new StringBuilder(),count,stringList);
        System.out.println(stringList);
    }

    private static void helper(String word, int depth, String s, int count, List<String> stringList) {
        if(depth == word.length()){
            if(count>0){
                s=s+count;
            }
            stringList.add(s);
            return;
        }
        else{
            //System.out.println("int "+s);
            helper(word,depth+1,s,count+1,stringList);
            if(count>0)s=s+count;
          //  System.out.println("int "+s);
            helper(word,depth+1,s+word.toCharArray()[depth],0,stringList);
        }
    }

    private static void helperMine(String word, int depth, StringBuilder sb,int precount, List<String> stringList) {
        if(depth == word.length()){
            System.out.println(sb.toString());
            stringList.add(sb.toString());
            return;

        }
        else{
            sb.append(precount+1);
            helperMine(word,depth+1,sb,precount+1,stringList);
            sb.deleteCharAt(sb.length()-1);
            sb.append(word.charAt(depth));
            helperMine(word,depth+1,sb,0,stringList);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    private static void helperMineAgain(String word, int depth, StringBuilder sb,int precount, List<String> stringList) {
       if(depth>=word.length()){
           if(precount>0) {
               sb.append(precount);
           }
           stringList.add(sb.toString());
           if(precount>0) {
               sb.deleteCharAt(sb.length() - 1);
           }
           return;
       }

       helperMineAgain(word,depth+1,sb,precount+1,stringList);
       if(precount>0){
           sb.append(precount);
       }
       sb.append(word.charAt(depth));
       helperMineAgain(word,depth+1,sb,0,stringList);
       sb.deleteCharAt(sb.length()-1);
       if(precount>0){
           sb.deleteCharAt(sb.length()-1);
       }
    }
}
