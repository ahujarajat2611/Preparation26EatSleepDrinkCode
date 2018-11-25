import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String s = br.readLine();
            String out_ = solve(s);
           // System.out.println(out_);
            wr.append(out_);
            wr.flush();
         }
         wr.close();
         br.close();
    }
    static String solve(String toBepalinString){
        int count [] = new int[256];
        for(char x:toBepalinString.toCharArray()){
            count[x-'a']++;
        }
        String returnedAns = new String();
        List<Character> charOddCount = new ArrayList<>();

        for(int i=0;i<256;i++){
            if (count[i]%2 == 1){
                charOddCount.add((char)(i+'a'));
                count[i]--;
                i--;
            }
            else if(count[i] !=0 && count[i]%2 ==0) {
                while (count[i]>0){
                    returnedAns = returnedAns+(char)(i+'a');
                    count[i] = count[i]-2;
                }
            }
        }
        StringBuilder sb =  new StringBuilder(returnedAns);
        if(charOddCount.size()>0) {
            returnedAns = sb.toString() + charOddCount.get(0) + sb.reverse().toString();
        }
        else {
            returnedAns = sb.toString() + sb.reverse().toString();
        }
       // System.out.println(returnedAns);
        return returnedAns;
        // Write your code here
    
    }
}