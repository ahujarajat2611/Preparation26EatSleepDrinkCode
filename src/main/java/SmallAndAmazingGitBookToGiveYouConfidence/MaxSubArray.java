package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class MaxSubArray {
    public static void main(String []args) {
    }
    public void kadan(int []temp){
        int maxSum = Integer.MAX_VALUE;
        int curretSum = 0;
        for(int num:temp){
            curretSum = Math.max(curretSum+num,num);
            maxSum = Math.max(curretSum,maxSum);
        }
        System.out.println("Max Sum" +maxSum);
    }

}
