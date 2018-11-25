package BasicAlgorithms.Array;

/**
 * Created by hadoop on 12/10/17.
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
}
