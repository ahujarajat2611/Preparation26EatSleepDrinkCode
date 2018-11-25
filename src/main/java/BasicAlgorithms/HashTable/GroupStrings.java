package BasicAlgorithms.HashTable;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class GroupStrings {
    public List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<String>> hm = new HashMap<>();

        for(String word:strings){
            if(word.length()>0){
                int offset = word.charAt(0)-'a' ;
                String updatedString = updated(word,offset);
                if(!hm.containsKey(updatedString)){
                    hm.put(updatedString,new ArrayList<>());
                }
                hm.get(updatedString).add(word);
            }
            else {
                String empty="";
                if(!hm.containsKey(empty)){
                    hm.put(empty,new ArrayList<>());
                }
                hm.get(empty).add("");
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String>value:hm.values()){
            result.add(new ArrayList<>(value));
        }
        return  result;
    }

    private String updated(String word, int offset) {
        StringBuilder sb = new StringBuilder(word);
        for(int i=0;i<word.length();i++){
            int newchar = sb.charAt(i)-offset;
            if(newchar<'a'){
                newchar = newchar+26;
            }
            sb.setCharAt(i,(char)newchar);

        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupStrings groupStrings = new GroupStrings();
        System.out.println(groupStrings.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}