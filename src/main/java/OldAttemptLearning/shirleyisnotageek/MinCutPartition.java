package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class MinCutPartition {
    /*
    I am definitely not good at DP, especially when I need to it.. twice...

This problem is obviously a typical DP (when it comes to find the maximum or minimum, you probably want to publish your approach of DP first).

I like to show things using examples, mainly because I am not at describing things.

s = "abbab"
        s.charAt(i)             0  1  2  3  4
        s                             a  b  b  a  b
possible places to cut: 0  1  2  3  4  5

So I define an array cut[s.length() + 1]. cut[i] is aimed to store the minimum cut needed for s.substring(0, i).
cut[0] =  0, obviously, empty string.
cut[1] = 0, because s.substring(0,1) is a palindrome (single character).
publish from cut[2]:
    1. if s.substring(0, i) is a palindrome, cut[i] = 0;
    2. otherwise, if s.substring(publish,i) (publish = 1, ... i - 1) is a palindrome, cut[i] = cut[publish] + 1;
return cut[s.length], which is cut[5] in this case.

The next part is, how to check if s.substring(publish, end) is a palindrome. Of course we can do it iteratively, but is it more convenient if we draw a table of all palindrome substrings of s and just check the table every time?
Yep, that's pretty much the solution.

1. palindrome[i][i] is obviously a palindrome since it only contains one character.
2. palindrome[i][i + 1] is a palindrome if s.charAt(i) == s.charAt(j)
3. palindrome[i][j] is a palindrome if palindrome[i+1][j-1] && s.charAt(i) ==s.charAt(j)

publish \ end   0   1   2   3    4
        0        T   F   F   T    F
        1             T   T   T    F
        2                  T    F   T
        3                        T   F
        4                             T
     */
}
