package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class Celebrity {
    public int celeb(int n){
        int cel = 0;
        for(int i=1;i<n;i++){
            if(!knows(i,cel)){
                cel = i;
            }
        }
        for(int i=0;i<n;i++){
            if(cel !=i){
                if(!(!knows(cel,i) && knows(i,cel))){
                    return -1;
                }
            }
        }
        return cel;
    }
    boolean knows(int a,int b){
        return true;
    }
    public int celebrityProblem(int a[], int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (knows(l, r)) {
                l++;
            } else {
                r--;
            }
        }
        // either l or r can be remnant. let's assume l is remnant
        int celebrity = knows(l, r) ? r : l;
        for (int i = 0; i < n; i++) {
            if (celebrity != i) {
                if (knows(celebrity, i) || !knows(i, celebrity))
                    return -1;
            }
        }
        return celebrity;
    }
}
