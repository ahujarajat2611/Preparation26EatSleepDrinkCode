package OldAttemptLearning.zhengyang2015;

/**
 * Created by hadoop on 23/8/17.
 */
public class CoinsLine {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(firstWillWin(n));
        int array[] = {1,2,4};
        int ans = maxvaluecoinnscollect(array,0);
        System.out.println("ans"+ans);
    }
    public static boolean firstWillWin(int n){
        return search(n) ;
    }

    private static boolean search( int n ){
        if(n ==0){
            return false;
        }
        if(n ==1){
            return true;
        }
        if(n ==2){
            return true;
        }
   //    return !(search(n-1) && search(n-2));
        boolean option1 = !search(n-1) ;
        boolean option2 = !search(n-2);
        return option1 || option2;

    }
    private static int maxvaluecoinnscollect(int array[],int index){
        if(index>=array.length){
            return 0;
        }
        else{
            int valueone = array[index];
            int valuetwo = array[index];
            if(index+1<array.length) {
                valuetwo = valuetwo+ array[index + 1];
            }
            int option1 = valueone + Math.min(maxvaluecoinnscollect(array,index+2),maxvaluecoinnscollect(array,index+3));
            int option2 = valuetwo + Math.min(maxvaluecoinnscollect(array,index+3),maxvaluecoinnscollect(array,index+4));
            return Math.max(option1,option2);
           // Math.max(array[index]+Math.max(maxvaluecoinnscollect(array,index+2),maxvalucoinnscollect(array,index+3),array[index]+array[index+1]+Math.max(maxvaluecoinnscollect(array,index+2),maxvaluecoinnscollect(array,index+3))))
        }

    }
}
