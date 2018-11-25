package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.
 */
public class SubarraySumSlildingWindow {
    void findSubarray(int []num,int n,int sum){
        int windowsum = num[0];
        int low = 0;
        int high =0;
        int count =0;
        // low pointer
        // high pointer
        // take low pointer and then move forward forward high pointer ...
        // caluclutae some window andd see ...
        while (low<n){
            while(windowsum<sum && high<n) {
                high++;
                windowsum = windowsum + num[high];
            }
            if(windowsum == sum){
                System.out.println(low);
                // since we have incremented high
                System.out.println(high);
                //windowsum = windowsum-num[low];
                //low++;
            }
           // while (windowsum>sum && low<n) {
                windowsum = windowsum - num[low];
                low++;
            //}
        }
    }

    public static void main(String[] args) {
        int []num = {2,6,0,9,7,3,1,4,1,10};
        int sum = 15;
        SubarraySumSlildingWindow subarraySumSlildingWindow = new SubarraySumSlildingWindow();
        subarraySumSlildingWindow.findSubarray(num,num.length-1,15);
    }
}
