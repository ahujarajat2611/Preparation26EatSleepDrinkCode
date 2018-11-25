package Gitbooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 15/9/17.
 */
public class Anagrams {
    public static void main(String[] args) {
        String anagrams[]={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> answer = new ArrayList<>();
        result(answer,anagrams);
        System.out.println(answer);
    }

    private static void result(List<List<String>> answer, String[] anagrams) {
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(String a:anagrams){
            char [] array = a.toCharArray();
            Arrays.sort(array);
            if(!hashMap.containsKey(String.valueOf(array))){
                hashMap.put(String.valueOf(array),new ArrayList<>());
            }
            hashMap.get(String.valueOf(array)).add(a);
        }
        answer.addAll(hashMap.values());
    }
    private static void resultagain(List<List<String>> ans,String [] anagrams){
        HashMap<Integer,List<String>> hashMap = new HashMap<>();
        for(String a:anagrams){
            int count []= new int[26];
            count = getCountArray(count,a.toCharArray());
            Integer hascode = gethashcode(count);
            if(!hashMap.containsKey(hascode)){
                hashMap.put(hascode,new ArrayList<>());
            }
            hashMap.get(hascode).add(a);
        }
        hashMap.values();

    }

    private static int gethashcode(int[] count) {
        int hash = 0;
        int a = 31;
        for(int ch:count){
            hash = hash*a + ch;
        }
        return hash;
    }

    private static int[] getCountArray(int[] count, char[] chars) {
        for(int i=0;i<chars.length;i++){
            count[chars[i]-'a']++;
        }
        return count;
    }
}
