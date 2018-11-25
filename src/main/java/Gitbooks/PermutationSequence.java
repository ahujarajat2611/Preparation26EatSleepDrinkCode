package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 12/9/17.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutationSequence(3,1));
    }
    String getPermutationSequence(int n,int k){
        List<Integer> integerList = new ArrayList<>();
        for( int i=1;i<=n;i++){
            integerList.add(i);
        }
        int [] fact = new int[n];
        fact[0]=1;
        for( int i=1;i<fact.length;i++){
            fact[i] = fact[i-1]*i;
        }
        String out="";
        for (int i=n;i>0;i--){
            System.out.println("k "+k);
            System.out.println("fac "+fact[i-1]);
            int index = k/fact[i-1];
            System.out.println("index"+(index));
            System.out.println("size"+integerList.size());
            out=out+ integerList.get((index-1));
            integerList.remove(index-1);
            k = k%fact[i-1];
            if(k ==0){
                for(int num:integerList){
                    out = out +num;
                }
                return out;
            }
        }
        return out;
    }
}
