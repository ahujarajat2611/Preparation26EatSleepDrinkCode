package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
/*
Maximum days to light candles

You are given heights of n candles .
First day you lit one candle
second day you need to lit two candles
Third day you need to lit three candles
..........
........
till possible.
After lighting candles the height of candles deduced
by 1 each day.You can also extinguish any candle you want
 but only at the end of day.
So you need to tell the maximum number number of days
, you can carry on lighting the candles.
Example : there are three candles of heights {2 , 2 ,2 }
Answer : 3
1.You light first candle on day one. heights -> {1,2,2}
2.You light second and third and extinguish first one . heights ->{1, 1,1}
3.You light all the candles. heights -{0,0,0}


This is actually a tricky question.
The tricky part is not on the actual implementation, in fact,
 there is no fancy algorithm here, but on how you think of the question.

In fact, the last paragraph was written 90 minutes ago, then when I tried to use an example to explain my first approach, I realized that is was wrong.

Then comes the second and third approach...

Then I realize the problem is as easy as the interview
 type suggests: A written test.

This is a simple Greedy approach.

Sort the array.
 Start from the maximum, each day we add an element
 and subtract the number of candles needed. So given

2 2 2

Day 1: 2 - 1 = 1
Day 2: 1 + 2 - 2 = 1
Day 3: 1 + 2 - 3 = 0

That's it. Simple. Yeah, simple....
 */
public class MaxDaysToLitCandles {
    public static int maxDays(int[] candles){
        if(candles == null || candles.length == 0)
            return 0;
        Arrays.sort(candles);
        int lit = candles[candles.length - 1] - 1;
        int count = 1;

        for(int i = candles.length - 2; i >= 0; i--){
            if(lit + (candles[i] - (count + 1)) < 0)
                break;
            lit += candles[i] - (++count);
        }
        return count;
    }
    public static int maxDaysMineAndCorrectAboveNotCOrrecte(int[] candles){
        if(candles == null || candles.length == 0)
            return 0;
        Arrays.sort(candles);
        int days =0;
        int sum =0;
        for(int i= candles.length-1;i>=0;i--){

            sum = sum + candles[i];
            if(sum -(days+1)>=0){
                days++;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        MaxDaysToLitCandles maxDaysToLitCandles = new MaxDaysToLitCandles();
        int []ar = {1,2,2,4,5};
        System.out.println(maxDaysMineAndCorrectAboveNotCOrrecte(ar));
        System.out.println(maxDays(ar));
    }
}

