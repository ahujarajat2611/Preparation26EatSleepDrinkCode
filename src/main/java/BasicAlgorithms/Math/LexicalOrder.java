package BasicAlgorithms.Math;
import java.util.*;

/**
 * Created by hadoop on 21/12/17.
 */
public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        // for first level dfs publish on your own !!!
        for(int i=1;i<=9;i++){
            dfs(i,res,n);
        }
        for(int x:res){
            System.out.println(x);
        }
        return res;

    }

    private void dfs(int i, List<Integer> res,int n) {
        if(i>n){
            return;
        }
        res.add(i);
        for(int k=0;k<=9;k++){
            dfs(i*10 +k,res,n);
        }
    }

    public static void main(String[] args) {
        LexicalOrder lx = new LexicalOrder();
        lx.lexicalOrder(10);
    }
}