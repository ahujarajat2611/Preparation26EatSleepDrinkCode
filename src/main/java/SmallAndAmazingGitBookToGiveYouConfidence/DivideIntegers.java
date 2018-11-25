package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.nt
 */
public class DivideIntegers {
    int divide(int x,int y){
        if(y ==0){
            return x>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if(x ==0){
            return x;
        }
        if(x <0 && y <0){
            return divideHelper(-1*x,-1*y);
        }
        if(x >0 && y >0){
            return divideHelper(x,y);
        }
        return -1 * divideHelper(Math.abs(x),Math.abs(y));
    }

    int divideHelper(int dividend,int divisor){
        int answer=0;
        System.out.println("dividen "+dividend);
        while (divisor<=dividend){
            int temp = divisor;
            int shift =1;
            while (temp<=dividend) {
                temp = temp << 1;
                shift = shift << 1;
            }
            answer = answer + shift>>1;
            dividend = dividend-temp>>1;
        }
        return answer;
    }
    int search ( int []array, int x){
        int i = 1;
        while (array[i] != x) {
            System.out.println(i);
            while (i-1<array.length && array[i - 1] <= x) {
                i = i * 2;
            }
            i = i / 2;
        }
        return i;
    }

    public static void main(String[] args) {
        DivideIntegers divideIntegers = new DivideIntegers();
      //  System.out.println(divideIntegers.search(new int[]{1,2,3,4,5,6,7,8,9},9));
        System.out.println(divideIntegers.divideHelper(12,4));
    }
}
