package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class WordPattern2_hard {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        HashMap<Character,String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        return wordPatternMatchHelper(pattern,0,str,0,hashMap,hashSet);
    }

    public boolean wordPatternMatchHelper(String pattern, int patindex, String str,int strindex,HashMap<Character,String> hashMap,HashSet<String> hashSet) {
       // System.out.println("pat"+patindex);
        //System.out.println("str"+strindex);
        //System.out.println("pat l"+pattern.length());
        //System.out.println("str l"+str.length());
        if(patindex == pattern.length()){
            if(strindex == str.length()){
                return true;
            }
        }
        if(patindex >= pattern.length()){
            return false;
        }
        if(strindex >= str.length()){
            return false;
        }

        Character patChar = pattern.charAt(patindex);
        if(hashMap.containsKey(patChar)){
            String matchedWord = hashMap.get(patChar);
            if(str.indexOf(matchedWord,strindex)==-1){
                return false;
            }
            if(str.length()<strindex+matchedWord.length()){
                return false;
            }
            String sub = str.substring(strindex,strindex+matchedWord.length());
            if(!sub.equals(matchedWord)){
                return false;
            }
            System.out.println("matched"+matchedWord);
            return wordPatternMatchHelper(pattern,patindex+1,str,strindex+matchedWord.length(),hashMap,hashSet);
        }
        else {
            for(int i=strindex;i<str.length();i++){
                String substring =str.substring(strindex,i+1);
                if(!hashSet.contains(substring)) {
                    hashMap.put(patChar, substring);
                    hashSet.add(substring);
                    System.out.println("sub "+substring);
                    if(wordPatternMatchHelper(pattern, patindex + 1, str, i + 1, hashMap, hashSet)){
                        System.out.println("here");
                        System.out.println(pattern.substring(patindex));
                        System.out.println(str.substring(i+1));
                        return true;
                    }
                    hashMap.remove(patChar);
                    hashSet.remove(substring);
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        WordPattern2_hard wordPattern2 = new WordPattern2_hard();
     //   "abab"
      //  "redblueredblue"
        System.out.println(wordPattern2.wordPatternMatch("abab","redblueredblue"));
    }
}