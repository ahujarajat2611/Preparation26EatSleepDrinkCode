package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashMap;

/**
 * Created by hadoop on 19/9/17.
 */
public class PermutationIndex{
    public static void main(String[] args) {
        PermutationIndex permutationIndex = new PermutationIndex();
        System.out.println(permutationIndex.index(new int[]{2,2,1,1}));
    }
    public int index(int []a){
        if(a == null || a.length ==0){
            return 0;
        }
        int ans =1;
        HashMap<Integer,Integer> cout = new HashMap<>();
        for( int i=0;i<a.length;i++){
            int smaller=0;
            cout.clear();
            cout.put(a[i],1);
            for(int j=i+1;j<a.length;j++){
                // Contains Key !!! (aj)
                //  means trying to see how many elements repeaat after a(j) .. and then factorial of thsoe numver to divide !!
                /// thats how we taking care of repeptitions
                if(cout.containsKey(a[j])){
                    cout.put(a[j],cout.get(a[j])+1);
                }
                else {
                    cout.put(a[j],1);
                }
                // smaller we are calculating anyways !!!
                // additional repeatation if yes how many pairs tht many factorial divide !!!!
                if(a[j]<a[i]){
                    smaller++;
                }
            }
            System.out.println(cout);
            System.out.println("count"+getDupFactor(cout));
            ans = ans+(smaller*factorial(a.length-i-1))/getDupFactor(cout);
        }
        return ans;
    }

    private int getDupFactor(HashMap<Integer, Integer> cout) {
        int rank=1;
        for(int a:cout.values()){
            rank = rank *factorial(a);
        }
        return rank;
    }

    private int factorial(int i) {
        if(i ==0){
            return 1;
        }
        if(i ==1){
            return 1;
        }
        return i*factorial(i-1);
    }

}
