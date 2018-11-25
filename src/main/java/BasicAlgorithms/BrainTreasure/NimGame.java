package BasicAlgorithms.BrainTreasure;

/**
 * Created by hadoop on 23/10/17.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n == 2){
            return true;
        }

        if(n == 3){
            return true;
        }

        if(!canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3)){
            return true;
        }
        return false;
    }
    boolean [] cache;
    public boolean canWinNimite(int n) {
        cache = new boolean[n+1];
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n == 2){
            return true;
        }

        if(n == 3){
            return true;
        }

        cache[0] = false;
        cache[1] = true;
        cache[2] = true;
        cache[3] = true;

        for(int i=4;i<=n;i++){
            cache[i]  = (!cache[i-1] || !cache[i-2] || !cache[i-3]);
        }
        // if getting false from anyof its child state means parent can win :)


        return cache[n];
    }
}