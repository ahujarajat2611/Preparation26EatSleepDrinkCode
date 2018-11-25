package zrzahid;

/**
 * Created by hadoop on 9/9/17.
 */
public class FIzbizz {

    public void fizzbuzz(int x){
        for(int i=1;i<=x;i++){
            if(i %3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            else if(i %3 ==0){
                System.out.println("Fizz");
            }
            else if( i %5 ==0){
                System.out.println("buzz");
            }
            else
                System.out.println(i);
        }
    }

}
