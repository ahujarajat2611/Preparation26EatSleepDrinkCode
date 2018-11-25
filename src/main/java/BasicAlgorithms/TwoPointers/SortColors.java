package BasicAlgorithms.TwoPointers;

class SortColors {
    public void sortColors(int[] a) {
        
        int start =0;
        int end = a.length-1;
        int middle = 0;
        while(middle<=end){
            if(a[middle] == 1){
                middle++;
            }
            else if(a[middle] == 0){
                swap(a,middle,start);
                start++;
                middle++;
            }
            else if(a[middle] == 2){
                swap(a,middle,end);
                end--;
            }
        }
    }
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}