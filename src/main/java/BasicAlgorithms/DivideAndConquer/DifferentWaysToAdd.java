package BasicAlgorithms.DivideAndConquer;

/**
 * Created by hadoop on 22/10/17.
 */
/*
	Different Ways to Add Parentheses
	Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

	Example 1
		Input: "2-1-1".

		((2-1)-1) = 0
		(2-(1-1)) = 2
		Output: [0, 2]
	Example 2
		Input: "2*3-4*5"

		(2*(3-(4*5))) = -34
		((2*3)-(4*5)) = -14
		((2*(3-4))*5) = -10
		(2*((3-4)*5)) = -10
		(((2*3)-4)*5) = 10
		Output: [-34, -14, -10, -10, 10]
		// till now divide and ocnqueue result was either one vlaue // or two value
		so we could add from left sizde of right side
		// or we had list and we hade to take union of left side and right here
		// here left side has list
		// right size has list
		// we need to multiple left size * right size (all possible options)
		// a different kind of divice and conquer
*/
import java.util.*;
public class DifferentWaysToAdd {
    //if there is parenthese then only one way but we want to add parenthses and see how
    // many results we can get .....
    List<Integer> res = new LinkedList<Integer>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        return diffWaysToComputeHelper(input,0,input.length()-1);
    }

    private List<Integer> diffWaysToComputeHelper(String input, int start, int end) {
        List<Integer> list = new ArrayList<>();

        if(start>end){
            return list;
        }
        // base case
        if(start == end && (input.charAt(start)>='0' && input.charAt(start)<='9')){
            list.add(Integer.parseInt(input.substring(start,end+1)));
            return list;
        }
        for(int mid= start ;mid<=end;mid++) {
            if (input.charAt(mid) == '+' || input.charAt(mid) == '-' || input.charAt(mid) == '*') {
                // hey recursion give me ans of leftside
                List<Integer> leftResult = diffWaysToComputeHelper(input, start, mid - 1);
                // hey recursion give me ans of rightside
                List<Integer> rightResult = diffWaysToComputeHelper(input, mid + 1, end);

                for (Integer left : leftResult) {
                    for (Integer right : rightResult) {
                        if (input.charAt(mid) == '+') {
                            list.add(left + right);
                        }
                        if (input.charAt(mid) == '-') {
                            list.add(left - right);
                        }
                        if (input.charAt(mid) == '*') {
                            list.add(left * right);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DifferentWaysToAdd differentWaysToAdd = new DifferentWaysToAdd();
        System.out.println(differentWaysToAdd.diffWaysToCompute("2*3-4*5"));
    }
}
/*
Question:
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +,- and *.

Example 1Input: "2-1-1".
((2-1)-1) = 0 (2-(1-1)) = 2
Output: [0, 2]

Example 2Input: "2*3-4*5"
(2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10 (2*((3-4)*5)) = -10 (((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]


Hints:
Divide and Conque.
For each sign, divide into two parts for before and after it.

Python:
class Solution:
    # @param {string} input
    # @return {integer[]}
    def diffWaysToCompute(self, input):
        ans = []
        for i in range(len(input)):
            c = input[i]
            if c in '+-*':
                a = self.diffWaysToCompute(input[:i])
                b = self.diffWaysToCompute(input[i + 1:])
                for m in a:
                    for n in b:
                        if c == '+':
                            ans.append(m + n)
                        elif c == '-':
                            ans.append(m - n)
                        elif c == '*':
                            ans.append(m * n)

        if not ans:
            ans.append(int(input))

        return ans
 */
