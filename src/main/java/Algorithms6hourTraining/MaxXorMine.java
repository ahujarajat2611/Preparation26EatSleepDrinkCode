package Algorithms6hourTraining;

/**
 * Created by hadoop on 29/12/17.
 */
/*

Create tree from MSB to LSB ( thats the technique being used here )
Insert in trie 0 go left
1 go right
while searching if 0 go right
1 go left get potentinal number with which it cna get
max xor sum and thats it get the max answer

 */
public class MaxXorMine {
    public static void main(String[] args) {
        MaxXorMine maxXor = new MaxXorMine();
        System.out.println(maxXor.getMaxxor(new int[]{3, 10, 5, 25}));
    }

    int getMaxxor(int []array){
        int ans = Integer.MIN_VALUE;
        Trie trie = new Trie();
        for(int i=0;i<array.length;i++){
            // get potentional number with which
            // i can get max xor !!!!!!
            intsertInTrie(trie,array[i]);
            int getmaxxornumber = getMaxXorNumber(trie,array[i]);
            if(ans<(getmaxxornumber^array[i])){
              //  System.out.println(ans);
                ans = getmaxxornumber^array[i];
            }
        }
        return ans;
    }
    // storinga number in trie is the deal breaker

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

    // again i wil traverse 31 bits andd finally i will find my number stored
    // that can be potentinal number for max xor !!!!
    //i try to find potentioanl max xor number
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
