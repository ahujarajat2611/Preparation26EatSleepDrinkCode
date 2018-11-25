package BasicAlgorithms.Array;

/**
 * Created by hadoop on 29/12/17.
 */
public class MaxXor {
    public static void main(String[] args) {
        MaxXor maxXor = new MaxXor();
        System.out.println(maxXor.getMaxxor(new int[]{3, 10, 5, 25}));
    }

    int getMaxxor(int []array){
        int ans = Integer.MIN_VALUE;
        Trie trie = new Trie();
        intsertInTrie(trie,array[0]);
        for(int i=1;i<array.length;i++){
            int getmaxxornumber = getMaxXorNumber(trie,array[i]);
            if(ans<(getmaxxornumber^array[i])){
              //  System.out.println(ans);
                ans = getmaxxornumber^array[i];
            }
            intsertInTrie(trie,array[i]);
        }
        return ans;
    }

    private class Trie{
        Trie left;
        Trie right;
        Integer number;
        // stroing number only at last ..
        // very imp trikc
        Trie(){
            number = null;
            left = null;
            right = null;
        }
    }

    void intsertInTrie(Trie root,Integer number){
        for(int bit = 31;bit>=0;bit--){
          //  int mask = number & 1<<bit;
            //  int mask = number & 1<<bit;
            int mask = 1<<bit;
            if((mask & number)!=0){
                if(root.right== null){
                    root.right = new Trie();
                }
                root = root.right;
            }
            else {
                if(root.left== null){
                    root.left = new Trie();
                }
                root = root.left;
            }
        }
        //save number at the last node
        root.number = number;
    }

    int getMaxXorNumber(Trie root,Integer number){

        for(int bit = 31;bit>=0;bit--){
            int mask = 1<<bit;
            if((mask & number)!=0){
                if(root.left== null){
                    root = root.right;
                }
                else {
                    root = root.left;
                }
            }
            else {
                if(root.right== null){
                    root = root.left;
                }
                else {
                    root = root.right;
                }
            }
        }
        return root.number;
    }
}
