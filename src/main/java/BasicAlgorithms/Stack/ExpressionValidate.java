package BasicAlgorithms.Stack;

import java.util.Stack;
// push open to stack
// check if next is also open
// push negative to stack
// if you get close check if previous is also cclose and stack top is negative
// in that case we found indexes of unnecessary adddition
//-top index and current index i
// else

// in short we getting (( we are storing negative index
// if we gettimmg )) and check if stack top has negaaitve index
// then we found indexes of string that has undenecessary additon !!
public class ExpressionValidate {

	public static String validateExpression(String expr) {

		char r[] = expr.toCharArray();
        char s[] = expr.toCharArray();
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		while (i < s.length) 
		{
			if (s[i] == '(') {
					if (s[i + 1] == '(') {
						st.push(-i);
					} else {
						st.push(i);
					}
				i++;
			} else if (s[i] != ')' && s[i] != '(') {
				i++;
			} else if (s[i] == ')') {
					int top = st.peek();
					if (s[i - 1] == ')' && top < 0) {
						r[-top] = '$';// mark publish as problem
						r[i] = '$';  // mark end as problem !!!
						st.pop();
					}

					else if (s[i - 1] == ')' && top > 0) {
						System.out.println("Something is wrong!!");
					}

					else if (s[i - 1] != ')' && top > 0)
						st.pop();
					i++;
			}
		}

		StringBuffer result = new StringBuffer();

		for (i = 0; i<r.length; i++) {
			if (r[i] == '$') {
				continue;
			}
			result.append(r[i]);
		}

		return result.toString();

	}

	public static void main(String[] args) {
		String expr = "((((((A+B)))C)))";
		System.out.println("Validate expression"+validateExpression(expr));

	}

}
/*
How to remove extra bracket from expressions like ((((A+B))C)) to give (A+B)C in the most optimized way?

Remember the input expression will be valid
expression and output expression generated must also be valid and should give the same result as the input expression.

This can be done in O(n) time complexity using stack data structure.

The algorithm

Start traversing the expression from left examining every bracket.
If you encounter "(" such that there is another "(" to the right of it,
this might be one of the extra brackets to be removed. However we can't be sure right now.
So put the minus times the index of this bracket in the integer stack.
(we put minus times the index to distinguish brackets having similar brackets to their right from the ones not having )
If you encounter "(" such that there is a character other than "(" to its right , put its index in the stack.
If you encounter ")" such that there is another ")" to its left and we have a negative number on the top of the stack, pop the stack and replace current ")" and bracket at the index minus times top of the stack with "$"(so that these brackets can be removed later and are useless).
If you encounter ")"
such that there is a character other than ")"
to its left and top of the stack has the positive number than you need that bracket so just pop the stack.
At the end we will have useless brackets replaced with "$" sign, which can be removed in a single traversal. Thus giving us an O(n) complexity. Here is the running code using above explained algorithm.
 */