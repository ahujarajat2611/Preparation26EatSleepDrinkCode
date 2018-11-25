package OldAttemptLearning.shirleyisnotageek;

import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
/*
Write a function that receives a stream of pairs: id (some unique integer) + weight (positive real number).
The stream ends with the special pair {0,0}.
The function should return one
the unique ids at random,
 with probability proportional
 to its weight (compared to the
 total weights sum when stream has ended).
Stream size and weights sum are unknown in advance, and you are allowed O(1) memory consumption.
Example: If this was the stream: {1,2},{2,2},{3,4},{4,10}, then id 2 would be returned with probability 1/9.

The hard part for this question
is that no extra space is allowed,
which means we cannot store the pairs.
 The method to generate random number
  based on weight can be found here. Basically based on each weight,
   we calculate the accumulated weight,
    then when we generate a random number
     from 1 to the accumulated weight,
     return the number at certain range.
     Using the above array as an example:

1, 2 -> 2
2, 2 -> 4
3, 4 -> 8
4, 10 -> 18

So if we generate a random number between
1 to 18, and if it is 3 or 4,
 then we should return 2. The probability is 2 / 18 = 1 / 9.

Now here comes the problem,
 we are not allowed to backtrack
 the already read array, what should we do?

One way is to keep generating
random number and update the number
 we need to output until
 we reach the end of the stream.
  So if we are at {3, 4}, we generate a random
   number at 6, this number is greater than the previous accumulated weight (4), so we update the number we need to output to 3. If the number we generated is 3, then we don't update the number. The probability of getting each number is based on its weight (assuming the uniform probability of generating a random number from 1 to accumulated weight).
 */

/**
 * Created by hadoop on 21/1/18.
 */
public class WeightedId {
    public int random(String fileName) throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader(fileName));
        Random r = new Random();
        int cum = 0;
        int sample = 0;
        int last = 0;
        while(in.hasNext()){
            int val = in.nextInt();
            int weight = in.nextInt();
            if(val == 0 && weight == 0)
                break;
            cum += weight;
            int p = r.nextInt(cum) + 1; // because weights are positive real numbers
            // given !!!
            if(p >= last && p <= cum)
                sample = val;
            last = cum;
        }
        return sample;
    }
}
