package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 23/9/17.
 */
public class PrintNumbers {

    List<Integer> nnumbers(int n){
        List<Integer> ans = new ArrayList<Integer>();
      //  nnumbersHelper(ans,n,0);
      //  System.out.println("ans"+ans);
        for(int i=1;i<=9;i++){
            ans.add(i);
            nnumbersHelper(ans,n-1,i);
            ans.remove(ans.size()-1);
        }
        return ans;
    }

    public static int counter =0;
    private void nnumbersHelper(List<Integer> ans, int n, int num) {
        if(n==0){
           // if(num!=0){
                ans.add(num);
           // }
            return;
        }
       // System.out.println(n);
       // System.out.println(num);

        counter++;
       // if(counter>1000){
        //    System.exit(1);
       // }
        for(int i=0;i<=9;i++){
            n=n-1;
            int oldnum = num;
            num = num*10 +i;
            nnumbersHelper(ans,n,num);
            n = n+1;
            num = oldnum;
        }
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        System.out.println(printNumbers.nnumbers(3));
    }
}
