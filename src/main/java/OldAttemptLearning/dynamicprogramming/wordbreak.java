package OldAttemptLearning.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 3/8/17.
 */
public class wordbreak {
    public static void main(String[] args) {
        String s = "eetcode";
        List<String> dict = new ArrayList<String>();
        dict.add("eet");
        dict.add("co");
        dict.add("d");
        Map<String,Boolean> set = new HashMap<String,Boolean>();
        System.out.println(wordBreak("eetcode",dict,set));
    }
    public static boolean wordBreak(String s, List<String> dict,Map<String,Boolean> set){

        System.out.println("string is "+s);
        if(dict.contains(s)){
            return true;
        }
        if(s.length() == 1) return false;

        if(set.containsKey(s)) return set.get(s);
        for(int i=0;i<s.length();i++){

            if(!set.containsKey(s.substring(0,i+1))){
                set.put(s.substring(0,i+1),wordBreak(s.substring(0,i+1),dict,set));
            }
            if(!set.containsKey(s.substring(i+1,s.length()))){
                set.put(s.substring(i+1,s.length()),wordBreak(s.substring(i+1,s.length()),dict,set));
            }

            if(wordBreak(s.substring(0,i+1),dict,set) && wordBreak(s.substring(i+1,s.length()),dict,set)){
                set.put(s,true);
                return true;
            }
            else {
                set.put(s,false);
            }
        }
        return false;
    }
}
