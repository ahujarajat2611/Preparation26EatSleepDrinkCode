package BasicAlgorithms.String;

import java.util.*;

/**
 * Created by hadoop on 14/10/17.
 */
public class PalindromePermutations {
    public List<String>generatePalindromes(String s){
        // check if possible to generate palindrome
        List<String> res = new ArrayList<>();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char c:s.toCharArray()){
            if(!hashMap.containsKey(c)){
                hashMap.put(c,1);
            }
            else {
                hashMap.put(c,hashMap.get(c)+1);
            }
        }

        char []array = s.toCharArray();
        char []permuteArray;
        if(array.length %2 ==1){
            permuteArray = new char[array.length/2];
        }
        else {
            permuteArray = new char[array.length/2];
        }
        Character mid = null;
        int y=0;
        System.out.println("permuse"+permuteArray.length);
        for(Map.Entry<Character,Integer> entry: hashMap.entrySet()){
            if(entry.getValue()%2 == 1 && mid == null){
                mid = entry.getKey();
            }
            else if(entry.getValue()%2 == 1 && mid != null) {
                return res;
            }
            for(int x=0;x<(entry.getValue()/2);x++){
                System.out.println("y "+y);
                permuteArray[y++]= entry.getKey();
            }
        }
        System.out.println("len "+permuteArray.length);
        for(char a:permuteArray){
            System.out.print(a);
        }
        System.out.println();
        Arrays.sort(permuteArray);
        List<Character> path = new ArrayList<>();
        boolean visited[] = new boolean[permuteArray.length];
        permutations(path,visited,permuteArray,res,mid);
        return res;
    }

    private void permutations(List<Character> path, boolean[] visited, char[] permuteArray, List<String> res,Character mid) {
        if(path.size() == permuteArray.length){
            StringBuilder sb = new StringBuilder();
            for(Character c:path){
                sb.append(c);
            }
            String firstHalf = sb.toString();
            String reverse = sb.reverse().toString();
            if(mid == null){
                res.add(firstHalf+reverse);
            }
            else {
                res.add(firstHalf+mid+reverse);
            }
            return;
        }
        for(int k=0;k<permuteArray.length;k++){
            if(visited[k]) continue;
                visited[k] = true;
                path.add(permuteArray[k]);
                permutations(path, visited, permuteArray, res, mid);
                visited[k] = false;
                path.remove(path.size() - 1);
                while (k < permuteArray.length - 1 && permuteArray[k] == permuteArray[k + 1]) {
                    k++;
                }
            }
        }
    public static void main(String args[]){
        PalindromePermutations palindromePermutations = new PalindromePermutations();
        List<Character> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        char []permuteArray = {'a','b','c'};
        Character mid = 'f';
        boolean visited[] = new boolean[3];

        palindromePermutations.permutations(list,visited,permuteArray,res,mid);
        System.out.println(res);
        System.out.println(palindromePermutations.generatePalindromes("aaaaa"));
    }
}
