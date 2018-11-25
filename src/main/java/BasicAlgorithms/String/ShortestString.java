package BasicAlgorithms.String;

/**
 * Created by hadoop on 11/11/17.
 */
public class ShortestString {
}
/*

Shortest Superstring Problem
4.6

Given a set of n strings arr[], find the smallest string that contains each string in the given set as substring. We may assume that no string in arr[] is substring of another string.

Examples:

Input:  arr[] = {"geeks", "quiz", "for"}
Output: geeksquizfor

Input:  arr[] = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"}
Output: gctaagttcatgcatc

Shortest Superstring Greedy Approximate Algorithm
Shortest Superstring Problem is a NP Hard problem. A solution that always finds shortest superstring takes exponential time. Below is an Approximate Greedy algorithm.

Let arr[] be given set of strings.

1) Create an auxiliary array of strings, temp[].  Copy contents
   of arr[] to temp[]

2) While temp[] contains more than one strings
     a) Find the most overlapping string pair in temp[]. Let this
        pair be 'a' and 'b'.
     b) Replace 'a' and 'b' with the string obtained after combining
        them.

3) The only string left in temp[] is the result, return it.

Two strings are overlapping if prefix of one string is same suffix of other string or vice verse. The maximum overlap mean length of the matching prefix and suffix is maximum.

Working of above Algorithm:

arr[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"}
Initialize:
temp[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"}

The most overlapping strings are "catgc" and "atgcatc"
(Suffix of length 4 of "catgc" is same as prefix of "atgcatc")
Replace two strings with "catgcatc", we get
temp[] = {"catgcatc", "ctaagt", "gcta", "ttca"}

The most overlapping strings are "ctaagt" and "gcta"
(Prefix of length 3 of "ctaagt" is same as suffix of "gcta")
Replace two strings with "gctaagt", we get
temp[] = {"catgcatc", "gctaagt", "ttca"}

The most overlapping strings are "catgcatc" and "ttca"
(Prefix of length 2 of "catgcatc" as suffix of "ttca")
Replace two strings with "ttcatgcatc", we get
temp[] = {"ttcatgcatc", "gctaagt"}

Now there are only two strings in temp[], after combing
the two in optimal way, we get tem[] = {"gctaagttcatgcatc"}

Since temp[] has only one string now, return it.

Below is C++ implementation of above algorithm.
// C++ program to find shortest superstring using Greedy
// Approximate Algorithm
#include <bits/stdc++.h>
using namespace std;

// Utility function to calculate minimum of two numbers
int min(int a, int b)
{
    return (a < b) ? a : b;
}

// Function to calculate maximum overlap in two given strings
int findOverlappingPair(string str1, string str2, string &str)
{
    // max will store maximum overlap i.e maximum
    // length of the matching prefix and suffix
    int max = INT_MIN;
    int len1 = str1.length();
    int len2 = str2.length();

    // check suffix of str1 matches with prefix of str2
    for (int i = 1; i <= min(len1, len2); i++)
    {
        // compare last i characters in str1 with first i
        // characters in str2
        if (str1.compare(len1-i, i, str2, 0, i) == 0)
        {
            if (max < i)
            {
                //update max and str
                max = i;
                str = str1 + str2.substr(i);
            }
        }
    }

    // check prefix of str1 matches with suffix of str2
    for (int i = 1; i <= min(len1, len2); i++)
    {
        // compare first i characters in str1 with last i
        // characters in str2
        if (str1.compare(0, i, str2, len2-i, i) == 0)
        {
            if (max < i)
            {
                //update max and str
                max = i;
                str = str2 + str1.substr(i);
            }
        }
    }

    return max;
}

// Function to calculate smallest string that contains
// each string in the given set as substring.
string findShortestSuperstring(string arr[], int len)
{
    // run len-1 times to consider every pair
    while(len != 1)
    {
        int max = INT_MIN;  // to store  maximum overlap
        int l, r;   // to store array index of strings
        // involved in maximum overlap
        string resStr;  // to store resultant string after
        // maximum overlap

        for (int i = 0; i < len; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                string str;

                // res will store maximum length of the matching
                // prefix and suffix str is passed by reference and
                // will store the resultant string after maximum
                // overlap of arr[i] and arr[j], if any.
                int res = findOverlappingPair(arr[i], arr[j], str);

                // check for maximum overlap
                if (max < res)
                {
                    max = res;
                    resStr.assign(str);
                    l = i, r = j;
                }
            }
        }

        len--;  //ignore last element in next cycle

        // if no overlap, append arr[len] to arr[0]
        if (max == INT_MIN)
            arr[0] += arr[len];
        else
        {
            arr[l] = resStr;   // copy resultant string to index l
            arr[r] = arr[len];  // copy string at last index to index r
        }
    }
    return arr[0];
}

// Driver program
int main()
{
    string arr[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"};
    int len = sizeof(arr)/sizeof(arr[0]);

    cout << "The Shortest Superstring is "
         << findShortestSuperstring(arr, len);

    return 0;
}
// This code is contributed by Aditya Goel
 */