package OldAttemptLearning.dynamicprogramming;

public class Solution {
    public static Integer cache[] ;

    public int numDecodings(String s) {

        cache= new Integer[s.length()+1];
        for(int i=0;i<s.length()+1;i++){
            cache[i]=-1;
        }
        if(s.equals(""))
            return 0;
        return topdp(s.toCharArray(),s.length()-1);

    }

    private static int topdp(char[] s, int i) {
        int numberofways = 0;

        if(i==0  && s[i]=='0'){
            return 0;
        }
        if(i==0 && s[i]!='0'){
            return 1;
        }
        if(i<0) return 1;

        if(cache[i] !=-1) return cache[i];
        if(s[i] !='0') {
            numberofways = numberofways+topdp(s, i - 1);
        }

        if(i-1>=0) {
            int value = Integer.parseInt(String.valueOf(s).substring(i - 1, i+1));
            if(value<=26 && value>=10){
                numberofways = numberofways + topdp(s,i-2);
            }
        }
        cache[i] = numberofways;
        return numberofways;
    }
}