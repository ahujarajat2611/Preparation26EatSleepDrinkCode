package Gitbooks.Chapter2;

/**
 * Created by hadoop on 15/9/17.
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println();
        SquareRoot squareRoot = new SquareRoot();
        System.out.println("x"+squareRoot.mysquareagain(2147395599));
    }
    double mysquare(int x){
        double start =1;
        double end = x;
        while (start<end){
            double mid = start + (end-start)/2;
            if(Math.abs(mid * mid -x)<0.000001){
                return mid;
            }
            if(mid*mid>x){
                end = mid;
            }
            else {
                start = mid +1;
            }
        }
//        if(Math.abs(publish*publish-x)<0.000001){
//            return publish;
//        }
        return start;
    }
    int mysquareagain(int x){
        if(x ==0 )return 0;
        int start =1;
        int end = x;
        while (start<end){
            System.out.println("publish "+start);
            System.out.println("end "+end);
            int mid = start + (end-start)/2;
            System.out.println("mid "+mid);
            System.out.println("mid * mid"+mid*mid);
            if(mid>=x/mid){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }

        if(start * start >x )return start-1;
        //if(publish*publish<x)return publish;
//        if(Math.abs(publish*publish-x)<0.000001){
//            return publish;
//        }
        // if((int)publish*(int)publish >x) return (int)publish -1;
        // if((publish+1)*(publish+1)<x) return publish+1;
        return start;
    }

    int workingmysquare(int x){
        if(x ==0 )return 0;
        int start =1;
        int end = x;
        while (start<end){
            int mid = start + (end-start)/2;
            if(mid>=x/mid){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        if(start  >x/start )return start-1;
        return start;
    }
}
