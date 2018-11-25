package SystemDesign;

/**
 * Created by hadoop on 16/12/17.
 */
public class MissingIn4billion {
}

/*

https://prismoskills.appspot.com/lessons/Programming_Puzzles/Missing_number_in_billion_integers_.jsp

Problem: Using 1GB of memory only, find the missing numbers in 4 billion integers stored in a file.

Solution: One integer takes 4 bytes, so 4 billion integers would take: 4 bytes * (4 * 109) = 16 GB

Since we have only 1 GB of memory, we cannot get all the integers into memory at once.

Even if we could get all numbers into memory, we would need some data-structure like an array where
each integer from the 4 billion lot would be kept and then we will scan the array to find holes.

The array to store the 4 billion integers need not be of type int []

It can be of type boolean [] also since all we need is a true/false to know whether an int is present or not.

Memory required to store 4 billion booleans = 1 bit * (4 * 109) = 4Gb = 0.5 GB (small b means bit and capital B means bytes).

So this seems doable with 1 GB of memory.
We have a boolean array as boolean numberPresent[4*1000*1000*1000], load a few numbers from the file in a loop and fill the boolean array.
Once all the integers have been processed, one pass through the array would give us all the missing numbers.

Only problem with this solution is that array indices can only be an integer and size of integer is:
231 = 2147483648 (~2 billion) and
232 = 4294967296 (~4 billion)

But 32nd bit is for the sign bit.
And so any index beyond 2 billion would be treated as a negative index.
To solve this, we will need two boolean arrays each with a capacity of 2 billion integers.
One array will store the presence of first billion integers while the next array will store the remaining 2 billion integers' presence.


What if the memory was limited to 10 MB instead of 1 GB ?


10MB = 107 booleans while space required is 4*109 booleans. Around 400 times more than we have.

To solve this, we create buckets of integers, each bucket covering 104 integers.

So first bucket will cover 0-10,000 integers, second bucket will cover 10,001-20,000 integers and so on.

To cover 4*109 integers, buckets required = 4*109 / 104 = 4*105

What information do we store in each bucket?
Clearly it cannot be all the integers in each bucket because then it will be beyond 10MB.

We store count of numbers in each bucket.
If there are no missing numbers in a bucket, then the number of integers in that bucket would be 10,000.
So we make a second pass on the buckets after processing all 4 billion integers. If any bucket has less than 10,000
count, then it has missing numbers and the 4 billion integers can be scanned only in that range to find the missing numbers.

Order of execution would be 3*O(n) and memory required would be = 4 bytes * (4*109/104) = 1.6 MB

 */