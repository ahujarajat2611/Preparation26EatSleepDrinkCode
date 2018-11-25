package Gitbooks.Chapter2;

/**
 * Created by hadoop on 17/9/17.
 */
public class MedianSortedArrays {
    public static void main(String[] args) {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        System.out.println("ans"+medianSortedArrays.findMedian(nums1,nums2));

    }
    public  double findMedian(int []nums1,int [] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if(m>n){
            return findMedian(nums2,nums1);
        }
        if(total%2 ==0){
            return (findMedianHelper(nums1,nums2,0,m-1,0,n-1,(m+n)/2)+
                    findMedianHelper(nums1,nums2,0,m-1,0,n-1,(m+n)/2+1))/2;
        }
        else {
            return findMedianHelper(nums1,nums2,0,m-1,0,n-1,(m+n)/2+1);
        }
    }
    /// imp thing is to calculate m , n fromm each arrya
    int findMedianHelper(int []nums1,int nums2[],int onestart,int oneend,int secondstart,int secondend,int k){
        int m = oneend-onestart+1;
        int n = secondend-secondstart+1;
        System.out.println("m"+m);
        System.out.println("n"+n);
        System.out.println("k"+k);
        if(m==0){
            return nums2[secondstart+k-1];
        }
        if(n ==0){
            System.out.println("k"+k);
            return nums1[onestart+k-1];
        }
        if(k==1){
            return Math.min(nums1[onestart],nums2[secondstart]);
        }
        if(k==0){
            return -1;
        }
        //// very im first mid length ...
        // since k/2 might be excedding m .. so take min of htat
        // for second just subretac fomr k
        int midFirstLength = Math.min(k/2,m);
        int midSecondLength = k-midFirstLength;
        System.out.println("mid length"+midFirstLength);
        System.out.println("mid length2"+midSecondLength);
        if(nums1[onestart+midFirstLength-1]<nums2[secondstart+midSecondLength-1]){
            /// k wil either change to k-firstMidlength

            // or k will change to k -seocndmid length
            findMedianHelper(nums1,nums2,onestart+midFirstLength,oneend,secondstart,secondstart+midSecondLength,k-midFirstLength);
        }
        else if(nums1[onestart+midFirstLength-1]>nums2[secondstart+midSecondLength-1]){
            findMedianHelper(nums1,nums2,onestart,onestart+midFirstLength,secondstart+midSecondLength,secondend,k-midSecondLength);
        }
        else{
            // if equal we have found ans /// kth number in both sorted matrix
            return nums1[onestart+midFirstLength-1];
        }
        return -1;
    }
}
