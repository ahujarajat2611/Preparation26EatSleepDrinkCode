package smallmomentsmakeitbigger26;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 14/12/17.
 */
public class ugly {

    public int[] ugly(int n, int []primes){

        int []index = new int[primes.length];
        int []res = new int[n+1];
        // this is the bottleneck


        // mainttains the indeex of all primes contrinuted
        // to the lowest vlaue
        int []pri = new int[primes.length];
         // by default all begin index has to be zero
        res[0] = 1;
        // very imp base case
        // n ugly numbers
        for(int i=1;i<=n;i++){
            res[i] = Integer.MAX_VALUE;
            for(int k=0;k<primes.length;k++){
                res[i] = Math.min(res[i],primes[k]*res[index[k]]);
            }
            for(int k=0;k<primes.length;k++){
                if(res[i] == primes[k]*res[index[k]]){
                    index[k]++;
                    // increment index if min value is equal
                }
            }
        }
        return res;
    }




    public int[] uglymine(int n, int []primes){

        int ans [] = new int[n+1];

        int colindex [] = new int[primes.length];

        // base case kaha se 1 aata that is most imp
        ans[0]=1;

        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int k=0;k<primes.length;k++){
                min = Math.min(min,primes[k]*ans[colindex[k]]);
            }

            for(int k=0;k<primes.length;k++){
                if(min == primes[k]*ans[colindex[k]]){
                    colindex[k]++;
                }
            }
            ans[i] = min;
        }
        return ans;
    }

    public static void main(String[] args) {
        ugly ugly = new ugly();
        ConsoleWriter.printArray(ugly.ugly(10,new int[]{3,4,5}));
        ConsoleWriter.printArray(ugly.uglymine(10,new int[]{3,4,5}));

    }

}
