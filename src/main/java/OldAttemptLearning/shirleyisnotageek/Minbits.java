package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class Minbits {
}

/*
Minimum bits required to
send a sequence of a deck of cards

Consider the 52 cards of a deck.
 You generated a random sequence for these cards and want to send that sequence to a receiver. You want to minimize the communication between you and the receiver, i.e., minimize the number of bits required to send the sequence.
What is the minimum number of bits required to send the sequence?
Hint: It is not 6 x 52

So first, how to come up with 6 * 52?
 Each card is in the range 1 - 52,
 so if we use 6 bits, there are 2^6 = 64 possibilities,
 which can cover all possible sequences.

Now we know that the bits required must include all possible sequences of that 52 cards,
 so how many possibilities? (52!).
 This means that we need n bits that
  2^n >= (52!),
   so the theoretical answer is that we need log2(52!) = 226 bits.

So how to get that limit?

The first approach( besides the 6 * 52 one):
We know that the first card has 52 possibilities,
 the second has 51, ..., the 20th has 33 possibilities,
  so for the first 20 cards, we need at least 6 bits for each.
Then the 21st has 32 possibilities, ... 36th has 17 possibilities, so the next 16 cards we need at least 5 bits.
Then the next 8 cards we need 4 bits.
Then 4 cards, 3 bits.
Then 2 cards, 2 bits.
Then 1 card, 1 bit.
And after we know 51 cards, we know what the 52th is, so we don't need any bits. Thus in total:

20 * 6 + 16 * 5 + 8 * 4 + 4 * 3 + 2 * 2 + 1 = 249 bits. This solution is still larger.

The second one:
Consider we first send out
k cards, which needs at most
 log2(Permu(k, 52)) bits,
 and now we have 52 - k cards.
  So we compute from 1 to 52 the
  k that can give us the minimum total bits required.
  We use recursion.
   Moreover, at each calling, the smaller number is already calculated, so we use an array to store at each n, the minimum bits required, thus can reduce some recursions.

However, Java has some problems with rounding (e.g., permu(1, 6) should return 3, but I get 4), so I cannot reach the optimized solution. See here for the C++ solution that can get to 227 bits.
 */