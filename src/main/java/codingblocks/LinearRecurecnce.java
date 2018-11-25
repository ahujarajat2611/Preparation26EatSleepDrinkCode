package codingblocks;

/**
 * Created by hadoop on 5/10/17.
 */
public class LinearRecurecnce {
    public static void main(String[] args) {
        //f(i) = f(i-1)+f(i-2) ... so we need first 2 terms if some recursion depedent on last
                //two terms
                  //      T *f1 = f2
                    //            T*f2 = f3
        //T*f3 = f4
        //fn = t*fn-1 =t^n-1 f1
        //t^n-1 can be solved using matrix exponantion
        // k*k --> k^3 logn  time complexity for matrix power somthing
        //
    }
}
