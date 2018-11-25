package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Find popular item in sorted array of natural numbers.
An item is popular is if its repeated n/4 times or more.
For Ex:
Input: 123444445678
Popular item is 4.
Liner scan is O(n),
but solution needs to be in O(logN) complexity and O(1) space complexity.

This is actually a very interesting problem.
 Since the popular item is defined as the
 element is repeated more than 1 / 4 times,
 and since it is a sorted array,
 so it can only occurs on 0, n / 4, n /2 and 3n/4 index.
  And the rest is just do binary search and get the range.
 */
public class PopularItems {
    public class PopularNumber {
        public void popular(int[] n){
            if(n == null || n.length == 0)
                return;
            int len = n.length;
            int[] check = {0, len / 4, len / 2, 3 * len / 4};
            for(int i = 0; i < 4; i++){
                if(i > 0 && n[check[i]] == n[check[i - 1]])
                    continue;
                int l = check[i];
                int start = binarySearchStart(n, n[l]);
                int end = binarySearchEnd(n, n[l]);
                //need to be larger than the ceil in case len / 4.0 is not an integer
                if(end - start + 1 >= Math.ceil(len / 4.0))
                    System.out.println(n[l]);
            }
        }
        private int binarySearchEnd(int[] n, int target){
            int len = n.length;
            int start = 0;
            int end = len - 1;
            while(start + 1 < end){
                int mid = (start + end) / 2;
                if(n[mid] <= target)
                    start = mid;
                else
                    end = mid;
            }
            if(n[end] == target)
                return end;
            else return start;
        }
        private int binarySearchStart(int[] n, int target){
            int len = n.length;
            int start = 0;
            int end = len - 1;
            while(start + 1 < end){
                int mid = (start + end) / 2;
                if(n[mid] >= target)
                    end = mid;
                else
                    start = mid;
            }
            if(n[start] == target)
                return start;
            else
                return end;
        }

        public void main(String[] args) {
            //int[] n = {1, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7, 8};
            int[] n = {1, 1, 2, 3, 4};
            popular(n);
        }
    }
}
