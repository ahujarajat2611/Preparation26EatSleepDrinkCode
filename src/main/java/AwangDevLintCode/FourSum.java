package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
import java.util.*;
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 4) {
            return rst;
        }
        Arrays.sort(numbers);
        //Pick 1st element
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {//Check for duplicate of 1st element
                continue;
            }
            //Pick 2nd element
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {//Check for duplicate of 2nd element
                    continue;
                }
                //Pick 3rd and 4th element
                int third = j + 1;
                int fourth = numbers.length - 1;
                while (third < fourth) {
                    int sum = numbers[i] + numbers[j] + numbers[third] + numbers[fourth];
                    if (sum < target) {
                        third++;
                    } else if (sum > target) {
                        fourth--;
                    } else {//sum == target
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[third]);
                        list.add(numbers[fourth]);
                        rst.add(list);
                        third++;
                        fourth--;
                        // in normal three sum also this technique is useful
                        // wondering how did you miss this ... just hard to understand !!!
                        // i can move those conditions to outside loop
                        // that also can be done !!!! yup ..
                        while (third < fourth && numbers[third] == numbers[third - 1]) {
                            third++;
                        }
                        while (third < fourth && numbers[fourth] == numbers[fourth + 1]){
                            fourth--;
                        }
                    }
                }
            }
        }
        return rst;
    }
}
