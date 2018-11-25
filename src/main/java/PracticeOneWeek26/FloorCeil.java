package PracticeOneWeek26;

/**
 * Created by hadoop on 8/12/17.
 */
public class FloorCeil {

    int getCeil(int []array, int target){
        int low = 0;
        int high = array.length-1;
        int ceil =0;
        while (low<high){
            int mid = low + (high - low)/2;
            if(target<=array[mid]){
               // ceil = array[mid];
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return array[low];
    }
    int count = 0;
    // if strict case
    int getFloor(int []array,int target){
        int low = 0;
        int high = array.length-1;
        int floor=0;
        while (low<high){
            count++;
            if(count>20){
                System.exit(1);
            }
            double middouble = (double)low + (double)((double)high-(double)low)/2;
            int mid = (int)Math.ceil(middouble);
            if(target>=array[mid]){
                low = mid;
            }
            else {
                //floor = array[mid];
                high = mid-1;
            }
        }
        return array[low];
    }
    int getFloorAgain(int []array,int target){
        int low = 0;
        int high = array.length-1;
        int floor=0;
        while (low<high){
            count++;
            if(count>20){
                System.exit(1);
            }
            double middouble = (double)low + (double)((double)high-(double)low)/2;
            int mid = (int)Math.ceil(middouble);
           // mid = low + (high-low)/2;
            if(target>=array[mid]){
                low = mid;
            }
            else {
                //floor = array[mid];
                high = mid-1;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        FloorCeil floorCeil = new FloorCeil();
        int array[]= new int[]{1,4,6};
        System.out.println(
        floorCeil.floor(array,3));
       // System.out.println(floorCeil.getCeil(array,3));
       // System.out.println(floorCeil.getFloor(array,3));
        System.out.println(floorCeil.getFloorAgain(array,3));

    }
    int floor(int []array, int target){
        int start =0;
        int end = array.length-1;

        while (start<end){
            int mid = start + (end-start+1)/2;
            if(target<array[mid]){ // it can never be flooorr for sure
                // wht ar eyou thinking baby ...
                end = mid-1;
            }
            else if(target>=array[mid]){
                start = mid;
            }
        }
        return start;
    }
}
