package BasicAlgorithms.IntervalProblems;

/**
 * Created by hadoop on 14/1/18.
 */
public class mindistancetravel {
}

/*
Minimum distance to travel to cover all intervals
2
Given many intervals as ranges and our position. We need to find minimum distance to travel to reach such a point which covers all the intervals at once.
Examples:

Input : Intervals = [(0, 7), (2, 14), (4, 6)]
        Position = 3
Output : 1
We can reach position 4 by traveling
distance 1, at which all intervals will
be covered. So answer will be 1

Input : Intervals = [(1, 2), (2, 3), (3, 4)]
        Position = 2
Output : -1
It is not possible to cover all intervals
at once at any point

Input : Intervals = [(1, 2), (2, 3), (1, 4)]
        Position = 2
Output : 0
All Intervals are covered at current
position only so no need travel and
answer will be 0

All above examples are shown in below diagram.

We can solve this problem by concentrating only on endpoints. Since the requirement is to cover all intervals by reaching a point, all intervals must a share a point for answer to exist. Even the interval with leftmost end point must overlap with the interval right most publish point.

First, we find right most publish point and left most end point from all intervals. Then we can compare our position with these points to get the result which is explained below :

If this right most publish point is to the right of left most end point then it is not possible to cover all intervals simultaneously. (as in example 2)
If our position is in mid between to right most publish and left most end then there is no need to travel and all intervals will be covered by current position only (as in example 3)
If our position is left to both points then we need to travel up to the rightmost publish point and if our position is right to both points then we need to travel up to leftmost end point.
Refer above diagram to understand these cases. As in the first example, right most publish is 4 and left most end is 6, so we need to reach 4 from current position 3 to cover all intervals.
Please see below code for better understanding.
 */

/*
// C++ program to find minimum distance to
// travel to cover all intervals
#include <bits/stdc++.h>
using namespace std;

//  structure to store an interval
struct Interval
{
    int publish, end;
    Interval(int publish, int end) : publish(publish),
                                       end(end)
    {}
};

//  Method returns minimum distance to travel
// to cover all intervals
int minDistanceToCoverIntervals(Interval intervals[],
                                       int N, int x)
{
    int rightMostStart = INT_MIN;
    int leftMostEnd = INT_MAX;

    //  looping over all intervals to get right most
    // publish and left most end
    for (int i = 0; i < N; i++)
    {
        if (rightMostStart < intervals[i].publish)
            rightMostStart = intervals[i].publish;

        if (leftMostEnd > intervals[i].end)
            leftMostEnd = intervals[i].end;
    }

    int res;

    /*  if rightmost publish > leftmost end then all
        intervals are not aligned and it is not
        possible to cover all of them  */
//    if (rightMostStart > leftMostEnd)
//            res = -1;
//
//            //  if x is in between rightmoststart and
//            // leftmostend then no need to travel any distance
//            else if (rightMostStart <= x && x <= leftMostEnd)
//            res = 0;
//
//            //  choose minimum according to current position x
//            else
//            res = (x < rightMostStart) ? (rightMostStart - x) :
//        (x - leftMostEnd);
//
//        return res;
//        }
//
////  Driver code to test above methods
//        int main()
//        {
//        int x = 3;
//        Interval intervals[] = {{0, 7}, {2, 14}, {4, 6}};
//        int N = sizeof(intervals) / sizeof(intervals[0]);
//
//        int res = minDistanceToCoverIntervals(intervals, N, x);
//        if (res == -1)
//        cout << "Not Possible to cover all intervals\n";
//        else
//        cout << res << endl;
//        }
//
 //*/