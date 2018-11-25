package Algorithms6hourTraining;
import java.util.*;
/**
 * Created by hadoop on 21/12/17.
 */





/*


If DP problem
 1)Find How many Options
 2)Find how all statrting points
 3) Find all operations taht you can perform from those starting points
 // ( Getting operation riight is perfect deal )
 */

/*
If recursion
    if there is no starting point then return false ;
1) Find all starting points
2) Find all options
      if(recursion())
   return false


 */
 //Find how many starting points i need in my answer !!!
// Find Starting points  !!!
    // Find operations  !!!
    //  if(Recursion ())
    // return false !!!!

// To sum up recursion and dp
    // Options and operations that you need to deal with
    // all options frmo that point and operations you
public class Game24 {
    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1) {
            return nums.get(0) - 24 < 1e-6;
        }
        // size is one but but it has to be equal to 24
        //
        // here we can maintain list and keeep updating before we send it to recursion
        // when list size shrinks to 1 we have found our and
        // all combintations and add answers to that list

        // (Starting State, Options, Operations )
        // These 3 things are required !!!
        // options from that state andd operations that you can do from that
        // state



        /*
        Starting state --> Options from starting State-> Operations frmo that options
         */
        /*

        If you have to consider all paths, backtracking will come into picture for sure !! so beware of that
        starting state :- (diff starting states ) -> differnt options (and operations --> backtrack to seee
        if any of the option returned true and thats it we got the answer !!!
         */
        /*


        in thhis case starting points are not fixed, we need to fix all starting points and then
        all options frmo those starting points and then recursion
        in previous question, we have fixed satrtng points and looping to get all options possible

         */
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<>();

                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nums2.add(nums.get(k));
                        }
                    }

                    nums2.add(nums.get(i) + nums.get(j));
                    if (solve(nums2)) {
                        return true;
                    }
                    // remove that ans and addd new ans to list
                    nums2.remove(nums2.size() - 1);

                    nums2.add(nums.get(i) - nums.get(j));
                    if (solve(nums2)) {
                        return true;
                    }
                    // backtracking simpy !!!
                    nums2.remove(nums2.size() - 1);

                    nums2.add(nums.get(i) * nums2.get(j));
                    if (solve(nums2)) {
                        return true;
                    }
                    nums2.remove(nums2.size() - 1);

                    if (nums.get(j) != 0) {
                        nums2.add(nums.get(i) / nums2.get(j));
                        if (solve(nums2)) {
                            return true;
                        }
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        /// AFTER ALL STARTING POINTS WE COULD NOT MEANS RETURN FALSE !!!
        // if we could not make size of list to 1 anyhow we have to return false no way we can do this
        return false;
    }
}