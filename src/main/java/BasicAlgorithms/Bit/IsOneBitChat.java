package BasicAlgorithms.Bit;

/**
 * Created by hadoop on 24/12/17.
 */
public class IsOneBitChat {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;){
            if(bits[i] ==0){
                i++;
                if(i == bits.length){
                    return true;
                }
            }
            // make two i++ for a[i] == 1
            else {
                i++;
                i++;
            }
        }
        return false;
    }
}
