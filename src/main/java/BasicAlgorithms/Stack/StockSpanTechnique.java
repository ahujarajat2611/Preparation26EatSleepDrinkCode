package BasicAlgorithms.Stack;
import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;

/**
 * Created by hadoop on 15/12/17.
 */
public class StockSpanTechnique {
    // check diagram
    //http://www.geeksforgeeks.org/the-stock-span-problem/
    static void calculateSpan(int price[], int n, int S[])
    {
        // Create a stack and push index of first element to it
        Stack<Integer> st= new Stack<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++)
        {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty())? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }
    void calculateSpanInEfficient(int price[], int n, int S[])
    {
        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++)
        {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--)
                S[i]++;
        }
    }

    public static void main(String[] args) {
        int []ar = {100, 80, 60, 70, 60, 75, 85};
        int []span = new int[ar.length];
         calculateSpan(ar,ar.length,span);
        ConsoleWriter.printArray(span);
    }
}
