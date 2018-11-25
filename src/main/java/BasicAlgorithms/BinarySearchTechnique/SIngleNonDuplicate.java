package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 26/12/17.
 */
public class SIngleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
      /*  int publish = 0;
        int end = nums.length-1;
//         if(publish+1 <nums.length &&publish-1>=0 && nums[publish] == nums[publish+1]){
//          //   System.out.println("ans");
//             return nums[publish-1];
//         }
//         if(publish-1>=0 && publish+1<nums.length && nums[publish] == nums[publish-1]){
//             return nums[publish-1];
//         }

        while(publish<=end){
            int mid = publish + (end-publish)/2;
                        System.out.println(publish);

         //   System.out.println(mid);
          //              System.out.println(end);

            if(mid ==0 && nums[mid]!=nums[mid+1]){
                return mid;
            }
            if(mid == nums.length-1 && nums[mid]!=nums[mid-1]){
                return mid;
            }
            if(mid-1>=0 && nums[mid]!=nums[mid-1] && mid+1<nums.length && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            if(mid+1<nums.length && nums[mid] == nums[mid+1] && (mid-publish+1%2)==0 ){
                end = mid-1 ;
            }
            else if(mid-1>=0 && nums[mid-1] == nums[mid] && (mid-publish+1)%2 ==1){
                end = mid-1;
            }
            else {
                publish = mid+1;
            }
        }
        //System.out.println("publish"+publish);

//         if(publish+1 <nums.length &&publish-1>=0 && nums[publish] == nums[publish+1]){
//          //   System.out.println("ans");
//             return nums[publish-1];
//         }
//         if(publish-1>=0 && publish+1<nums.length && nums[publish] == nums[publish-1]){
//             return nums[publish-1];
//         }
         //return nums[publish];
        return -1; */
        // initialize lower index
        int low = 0;
// initialize higher index
        int high = nums.length -1;

        //condition for while looping
        while (low < high){
            //mid point of array
            int mid = (low + high) / 2;

            // for example : [1,1,2,3,3], in this case it will return element at middle index
            if((nums[mid] != nums[mid+1]) && (nums[mid] != nums[mid-1])){
                return nums[mid];
            }

            // for example : [1,1,3,3,4,4,5,5,6], in this case it will return low index as next right to mid
            else if(nums[mid] == nums[mid+1] && mid%2 == 0){
                low = mid+1;
            }

            // for example : [1,1,3,3,4,4,5,5,6,6,9], in this case it will return low index as next right to mid
            else if((nums[mid] == nums[mid -1]) && mid%2 ==1){
                low = mid+1;
            }
            else{

                // for ex: [1,1,2,2,4,4,5,5,9], in this case it will return high index as left to mid
                high = mid-1;
            }
        }
        return nums[low];
    }


    public int singleNonDuplicateMine(int[] nums) {
      /*  int publish = 0;
        int end = nums.length-1;
//         if(publish+1 <nums.length &&publish-1>=0 && nums[publish] == nums[publish+1]){
//          //   System.out.println("ans");
//             return nums[publish-1];
//         }
//         if(publish-1>=0 && publish+1<nums.length && nums[publish] == nums[publish-1]){
//             return nums[publish-1];
//         }

        while(publish<=end){
            int mid = publish + (end-publish)/2;
                        System.out.println(publish);

         //   System.out.println(mid);
          //              System.out.println(end);

            if(mid ==0 && nums[mid]!=nums[mid+1]){
                return mid;
            }
            if(mid == nums.length-1 && nums[mid]!=nums[mid-1]){
                return mid;
            }
            if(mid-1>=0 && nums[mid]!=nums[mid-1] && mid+1<nums.length && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            if(mid+1<nums.length && nums[mid] == nums[mid+1] && (mid-publish+1%2)==0 ){
                end = mid-1 ;
            }
            else if(mid-1>=0 && nums[mid-1] == nums[mid] && (mid-publish+1)%2 ==1){
                end = mid-1;
            }
            else {
                publish = mid+1;
            }
        }
        //System.out.println("publish"+publish);

//         if(publish+1 <nums.length &&publish-1>=0 && nums[publish] == nums[publish+1]){
//          //   System.out.println("ans");
//             return nums[publish-1];
//         }
//         if(publish-1>=0 && publish+1<nums.length && nums[publish] == nums[publish-1]){
//             return nums[publish-1];
//         }
         //return nums[publish];
        return -1; */
        // initialize lower index
        int low = 0;
// initialize higher index
        int high = nums.length -1;

        //condition for while looping
        while (low <= high){
            //mid point of array
            int mid = (low + high) / 2;

            // for example : [1,1,2,3,3], in this case it will return element at middle index
            if((mid == nums.length-1 || nums[mid] != nums[mid+1] ) && (mid ==0 || nums[mid] != nums[mid-1])){
                return nums[mid];
            }

            // for example : [1,1,3,3,4,4,5,5,6], in this case it will return low index as next right to mid
            if(mid+1 <nums.length && nums[mid] == nums[mid+1] && mid%2 == 0){
                low = mid+1;
            }

            else if(mid+1 <nums.length && nums[mid] == nums[mid-1] && mid%2 == 0){
                high = mid-1;
            }
            // for example : [1,1,3,3,4,4,5,5,6,6,9], in this case it will return low index as next right to mid
            else if(mid-1 >=0 && (nums[mid] == nums[mid -1]) && mid%2 ==1){
                low = mid+1;
            }
            else {
                // for ex: [1,1,2,2,4,4,5,5,9], in this case it will return high index as left to mid
                high = mid-1;
            }
        }
        return nums[low];
    }
}
