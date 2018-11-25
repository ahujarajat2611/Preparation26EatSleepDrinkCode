package OldAttemptLearning.dynamicprogramming;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hadoop on 5/8/17.
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
       // int x = nthUglyNUmber(5,index2,index3,index5);
        //System.out.println(x);
    }

//    private static int nthUglyNUmber(int i, int index2, int index3, int index5) {
//        if(i==1){
//            return 1;
//        }
//        int number = Integer.MAX_VALUE;
//
//        Math.min(number,Math.min(Math.min(2*nthUglyNUmber(i-1,index2,index3,index5),3*nthUglyNUmber(i-1,index2,index3,index5)),5*nthUglyNUmber(i-1,index2,index3,index5)));
//
//
//
//
//
//        for(int i = Math.min(nthUglyNUmber(5, index2, index3, n-1)/2,; i<n; i++){
//            number = Math.min(number,Math.min(Math.min(nthUglyNUmber(5, index2, index3, i)*2,nthUglyNUmber(5, index2, index3, i)*3),nthUglyNUmber(5, index2, index3, i)*5));
//        }
//        return number;
//    }

        public int nthugly(int n, int [] primes){
            if(primes == null || primes.length ==0 || n<=0){
                return 0;
            }
            Set<Long> hashset= new TreeSet<Long>();
            hashset.add(1l);

            for(int i=1;i<n;i++){
                Long current =0l;
                Iterator<Long>itr = hashset.iterator();
                if(itr.hasNext()){
                    current = itr.next();
                    itr.remove();
                }

                for(int j=0;j<primes.length;j++){
                    Long value = current*primes[j];
                    if(!hashset.contains(value)){
                        hashset.add(value);
                    }
                }
            }

            Long current =0l;
            Iterator<Long>itr = hashset.iterator();
            if(itr.hasNext()){
                current = itr.next();
                itr.remove();
            }
            return current.intValue();
        }
    }