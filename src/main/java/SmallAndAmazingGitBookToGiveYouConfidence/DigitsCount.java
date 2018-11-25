package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.
 */
public class DigitsCount {
    public long digitsCount(int k,int n){
        long result = 0;
        for(int base = 1;base<=n;base= base*10){
            int highernumber = n/base;
            int lowernumber = n%base;
            System.out.println(lowernumber);
            System.out.println(highernumber);
            if(highernumber % 10 >k){
                result = result + (highernumber/10+1)*base;
            }
            else {
                result = result + (highernumber/10)*base;
            }
            if(highernumber%10 == k){
                result = result + (lowernumber + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DigitsCount digitsCount = new DigitsCount();
       // System.out.println(digitsCount.digitsCount(1,1410065408));
        System.out.println(digitsCount.count(34333));
    }
    int count (int x){

        int ans= 0;
        for(int i=1;i<=x;i++){
            String y = String.valueOf(i);
            if(y.length()>=3){
                if(y.charAt(2) == '1'){
                    ans++;
                }
            }

        }
        return ans;

    }
}
