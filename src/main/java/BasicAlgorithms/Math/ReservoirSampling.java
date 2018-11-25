package BasicAlgorithms.Math;// An efficient Java program to randomly
// select k items from a stream of items


/*
Reservoir sampling is a family of randomized algorithms
for randomly choosing k samples from a list of n items, where n is either a very large or unknown number. Typically n is large enough that the list doesn’t fit into main memory. For example, a list of search queries in Google and Facebook.

So we are given a big array (or stream) of numbers (to simplify),
 and we need to write an efficient function to randomly select k
 numbers where 1 <= k <= n. Let the input array be stream[].

A simple solution is to create an array reservoir[] of maximum size k.
 One by one randomly select an item from stream[0..n-1].
 If the selected item is not previously selected, then put it in reservoir[]. To check if an item is previously selected or not, we need to search the item in reservoir[]. The time complexity of this algorithm will be O(k^2).
  This can be costly if k is big. Also, this is not efficient if the input is in the form of a stream.

It can be solved in O(n) time. The solution also suits well for
 input in the form of stream. The idea is similar to this post. Following are the steps.

1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
2) Now one by one consider all items from (k+1)th item to nth item.
…a) Generate a random number from 0 to i where i is index of current item in
stream[]. Let the generated random number is j.
…b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]

Following is C implementation of the above algorithm.
 */
import java.util.Arrays;
import java.util.Random;
public class ReservoirSampling 
{
    // A function to randomly select k items from stream[0..n-1].
    static void selectKItems(int stream[], int n, int k)
    {
        int i;   // index for elements in stream[]
         
        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int reservoir[] = new int[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];
         
        Random r = new Random();
         
        // Iterate from the (k+1)th element to nth element
        for (; i < n; i++)
        {
            // Pick a random index from 0 to i.
            int j = r.nextInt(i + 1);
             
            // If the randomly  picked index is smaller than k,
            // then replace the element present at the index
            // with new element from stream
            if(j < k)
                reservoir[j] = stream[i];           
        }
         
        System.out.println("Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }
     
    //Driver Program to test above method
    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 5;
        selectKItems(stream, n, k);

        // lets pick second last
        /*

        k/n-4 -> lets say a particular index gets secelccetd( j )
         now j should not come in subsequenct stream numbers when are seelcteing random numbers for them
         ... so n-4th number to stay in the samplle

         selcect j index * dont selec j index at n-3 * dont seleced at n-2 * dont seelct at n-1 dont select at n

         k/n-4 * ( 1-1/n-3) * (1-1/n-2) * (1-1/n-1) * (1-1/n)


         */
    }
}
//This code is contributed by Sumit Ghosh
/*
How does this work?
To prove that this solution works perfectly,
we must prove that the probability that any item stream[i] where 0 <= i < n will be in final reservoir[] is
k/n. Let us divide the proof in two cases as first k items are treated differently.

Case 1: For last n-k stream items, i.e., for stream[i] where k <= i < n
For every such stream item stream[i], we pick a random index from 0 to i
 and if the picked index is one of the first k indexes,
 we replace the element at picked index with stream[i]

To simplify the proof, let us first consider the last item.
 The probability that the last item is in final reservoir = The probability that one of the first
  k indexes is picked for last item = k/n (the probability of picking one of the k items from a list of size n)

Let us now consider the second last item. The probability that the second last item is in final reservoir[] =
 [Probability that one of the first k indexes is picked in iteration for
 stream[n-2]] X [Probability that the index picked in iteration for stream[n-1] is not same as index picked for stream[n-2] ] = [k/(n-1)]*[(n-1)/n] = k/n.

Similarly, we can consider other items for all stream items from stream[n-1] to stream[k] and generalize the proof.

Case 2: For first k stream items, i.e., for stream[i] where 0 <= i < k
The first k items are initially copied to reservoir[] and may be removed later in iterations for stream[k] to stream[n].
The probability that an item from stream[0..k-1] is in final array = Probability that the item is not picked when items stream[k], stream[k+1], …. stream[n-1] are considered = [k/(k+1)] x [(k+1)/(k+2)] x [(k+2)/(k+3)] x … x [(n-1)/n] = k/n
 */