package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 7/1/18.
 */
public class FindPeakII {
}
/*
Question:
There is an integer matrix which has the following features:

The numbers in adjacent positions are different.
The matrix has n rows and m columns.
For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
We define a position P is a peek if:

A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]

Find a peak element in this matrix. Return the index of the peak.

Example:
Given a matrix:

[ [1 ,2 ,3 ,6 ,5],
  [16,41,23,22,6],
  [15,17,24,21,7],
  [14,18,19,20,10],
  [13,14,11,10,9] ]

return index of 41 (which is [1,1]) or index of 24 (which is [2,2])

Solution 1: Binary search for row
Steps:
1. Get the maximum point in the center row, A[mid][col].
2.
If A[mid][col] < A[mid + 1][col], cut off the top half(l = mid + 1)
                     A[mid][col] < A[mid + 1][col]: the bottom half mush contains a peak element
If A[mid][col] < A[mid - 1][col], cut off the top half(r = mid - 1)
                     A[mid][col] < A[mid - 1][col]: the top half mush contains a peak element
Else, return A[mid][col]

                     A[mid][col] > A[mid-1][col] and > A[mid+1][col] and it is the largest in row => peak element

Python:
class Solution:
    #@param A: An list of list integer
    #@return: The index of position is a list of integer, for example [2,2]
    def findPeakII(self, A):
        # write your code here
        if not A:
            return []

        l, r = 1, len(A) - 2
        ans = []

        while l <= r:
            mid = l + (r - l) / 2
            col = self.find(A[mid])

            if A[mid][col] < A[mid - 1][col]:
                r = mid - 1
            elif A[mid][col] < A[mid + 1][col]:
                l = mid + 1
            else:
                ans.append(mid)
                ans.append(col)
                return ans

        return []

    def find(self, a):
        ans = 0
        for i in range(len(a)):
            if a[i] > a[ans]:
                ans = i

        return ans
 */

/*
Solution 3: Binary search for row and column
Step 1: binary search for row
Step 2: binary search for column
Step 3: repeat Step 1 & 2 until finding peak.


Python:
class Solution:
    #@param A: An list of list integer
    #@return: The index of position is a list of integer, for example [2,2]
    def findPeakII(self, A):
        # write your code here
        if not A:
            return []

        u, d = 1, len(A) - 2
        l, r = 1, len(A[0]) - 2
        ans = []

        while l <= r and u <= d:
            midRow = u + (d - u) / 2
            col = self.find(A, midRow, u, d, l, r, True)

            if A[midRow][col] < A[midRow - 1][col]:
                d = midRow - 1
            elif A[midRow][col] < A[midRow + 1][col]:
                u = midRow + 1
            else:
                ans.append(midRow)
                ans.append(col)
                break

            midCol = l + (r - l) / 2
            row = self.find(A, midCol, u, d, l, r, False)

            if A[row][midCol] < A[row][midCol - 1]:
                r = midCol - 1
            elif A[row][midCol] < A[row][midCol + 1]:
                l = midCol + 1
            else:
                ans.append(row)
                ans.append(midCol)
                break

        return ans

    def find(self, A, num, u, d, l, r, isRow):

        if isRow:
            ans = l
            for i in range(l + 1, r + 1):
                if A[num][i] > A[num][ans]:
                    ans = i
        else:
            ans = u
            for i in range(u + 1, d + 1):
                if A[i][num] > A[ans][num]:
                    ans = i

        return ans
 */