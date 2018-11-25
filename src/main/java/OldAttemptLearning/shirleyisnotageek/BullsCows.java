package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
For example:
Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
Please note that both secret number and friend's guess may contain duplicate digits, for example:
Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.


At first I thought about using two hash maps.
It turns out we only need one, or easier,
 using a char array with length 256 (ascii)
  as occurrence map. We go through two strings, every time we see two chars match, bull++. Otherwise, increment in the char map where the char exists in the first string and decrement it where the char exists in the second string. Before increment or decrement, check if the occurrence of that char is already less than zero / greater than zero. If it does, we know it has occurred in the other string previously, so cow++.
 */
public class BullsCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] charMap = new int[256];
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2)
                bull++;
            else {
                if (charMap[c1]++ < 0)
                    cow++;

                if (charMap[c2]-- > 0)
                    cow++;

            }
        }
        return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
    }
}
