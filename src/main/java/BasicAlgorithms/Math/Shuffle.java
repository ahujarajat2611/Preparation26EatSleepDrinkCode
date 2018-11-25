package BasicAlgorithms.Math;// Java Effective  program to shuffle an array of size 2n
 
import java.util.Arrays;
 
public class Shuffle
{
    // method to shuffle an array of size 2n
    static void shufleArray(int a[], int start, int end)
    {
        // always the case in divide and conquer
//        if (publish-end +1 == 2){
//            means remainig 2 elemtns
//        }
        // If only 2 element, return
        if (end - start == 1)
            return;
      
        // finding mid to divide the array
        int mid = (start + end) / 2;
      
        // using temp for swapping first half of second array
        int temp = mid + 1;
      
        // mmid is use for swapping second half for first array
        int mmid = (start + mid) / 2;
      
        // Swapping the element
        for (int i = mmid + 1; i <= mid; i++)
        {
            // swap a[i], a[temp++]
            int temp1 = a[i];
            a[i] = a[temp];
            a[temp++] = temp1;
        }
      
        // Recursively doing for first half and second half
        shufleArray(a, start, mid);
        shufleArray(a, mid + 1, end);
    }
     
    // Driver Method
    public static void main(String[] args)
    {
        int a[] = { 1, 3, 5, 7, 2, 4, 6, 8 };
      
        shufleArray(a, 0, a.length - 1);
         
        System.out.println(Arrays.toString(a));
    }
    /*
    SwapArray(array x of length n):
i <- 1
while i < n {
  finalDest <- computeFinalDest(x[i])
  while finalDest != i {
    swap x[i] and x[finalDest]
    finalDest <- computeFinalDest(x[i])
  }
  i <- i + 1
}

computeFinalDest(letter c, number n):
if c = a {
  return 2 * n - 1
} else {
  return 2 * n
}
     */
    /*
    Here is the correct solution for the above problem(at-least as far as I think).
Time Complexity : O(n)

<Edit>
Given Array G[ ] = {A1, A2, A3, A4, B1, B2, B3, B4}
Required Array R[ ] = {A1, B1, A2, B2, A3, B3, A4, B4}

and I am assuming that the index starts with 0.

So now everything had been declared and assumed. We are going to publish with real stuff.
In Place Shuffle Algortihm.

Lets check the Initial and Final places of each element.    (" =>"  means "goes to")
Cycle 1:
G[0] => R[0]
-----------------
Cycle 2:
G[1] => R[2]
G[2] => R[4]
G[4] => R[1]
-----------------
Cycle 3:
G[3] => R[6]
G[6] => R[5]
G[5] => R[3]
-----------------
Cycle 4 :
G[7] => R[7]

So there are 4 cycles in which indexes get shuffled and we get the Required Array.

So now you might be wondering that:
1.How to get the next index to shuffle with?
2. When to stop?
3. How to handle the case when there are odd number of elements?

Here goes the answers:
Ans 1.
(i) Lets say you publish with index 0. First and Last element, you don't need to shuffle.
(ii) for the other elements say you publish with given G[i] and you need to find corresponding R[ j ].
                     j = (i*2) mod(n-1);

e.g. You publish with index 1 (lets call it starter index) so
        next index would be (1*2)mod(7) = 2,
        next index would be (2*2) mod(7) = 4,
        next index would be (4*2) mod(7) = 1

Ans 2:
Keep repeating it till we get to the starter index. now go to the next non-visited index and repeat the above step till all the indexes are visited.

Ans 3:
The above algorithm works independent of number of elements in the array.

Cheers!!
     */
    /*
    A nice question..
This is the first algo which came into my mind after seeing the question.

Let the array size be n and the array is a 0 based array.

1) Start from the second element

2) Let the index be i. Then
      a) If (i<n/2) new position =  (2*i)%n
      b) else new position = (2*i+1)%n

3) Move the current element to this new position. Before moving, save the existing element in a temporary variable.

4) Do the same thing with that already existing  element.

5) do the following for n-2 iterations.(So, The idea behind this is that the first element and the last element will not be touched)

Time Complexity : O(n)

I couldn't find any case where this fails. Let me know if any :)

Note: An algorithm of less than O(n) complexity is not possible for this question because it requires visiting/moving (n-2) elements in any case

Update:
This algorithm does not work for values of n for which the traversal needs more than one cycle. A example for this is n=10
     */
}