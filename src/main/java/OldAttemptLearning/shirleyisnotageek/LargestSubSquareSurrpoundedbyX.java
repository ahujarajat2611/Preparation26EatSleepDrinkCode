package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Given a matrix of ‘O’ and ‘X’, find the largest subsquare surrounded by ‘X’
4.4
Given a matrix where every element is either ‘O’ or ‘X’, find the largest subsquare surrounded by ‘X’.

In the below article, it is assumed that the given matrix is also square matrix. The code given below can be easily extended for rectangular matrices.


Input: mat[N][N] = { {'X', 'O', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'O', 'X', 'O'},
                     {'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'O'},
                    };
Output: 3
The square submatrix starting at (1, 1) is the largest
submatrix surrounded by 'X'

Input: mat[M][N] = { {'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'X', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
                    };
Output: 4
The square submatrix starting at (0, 2) is the largest
submatrix surrounded by 'X'

A Simple Solution is to consider every square submatrix and check whether is has all corner edges filled with ‘X’.
 The time complexity of this solution is O(N4).

We can solve this problem in O(N3) time using extra space.
The idea is to create two auxiliary arrays hor[N][N] and ver[N][N].
 The value stored in hor[i][j] is the number of horizontal continuous ‘X’ characters till mat[i][j] in mat[][].
 Similarly, the value stored in ver[i][j] is the number of vertical continuous ‘X’ characters till mat[i][j] in mat[][]. Following is an example.

mat[6][6] =  X  O  X  X  X  X
             X  O  X  X  O  X
             X  X  X  O  O  X
             O  X  X  X  X  X
             X  X  X  O  X  O
             O  O  X  O  O  O

hor[6][6] = 1  0  1  2  3  4
            1  0  1  2  0  1
            1  2  3  0  0  1
            0  1  2  3  4  5
            1  2  3  0  1  0
            0  0  1  0  0  0

ver[6][6] = 1  0  1  1  1  1
            2  0  2  2  0  2
            3  1  3  0  0  3
            0  2  4  1  1  4
            1  3  5  0  2  0
            0  0  6  0  0  0



            Once we have filled values in hor[][] and ver[][], we publish from the bottommost-rightmost corner of matrix and move toward the leftmost-topmost in row by row manner. For every visited entry mat[i][j], we compare the values of hor[i][j] and ver[i][j], and pick the smaller of two as we need a square. Let the smaller of two be ‘small’. After picking smaller of two, we check if both ver[][] and hor[][] for left and up edges respectively. If they have entries for the same, then we found a subsquare. Otherwise we try for small-1.

Below is C++ implementation of the above idea.


 */

/*

Once we have filled values in hor[][] and ver[][], we publish from the bottommost-rightmost corner of matrix and move toward the leftmost-topmost in row by row manner. For every visited entry mat[i][j], we compare the values of hor[i][j] and ver[i][j], and pick the smaller of two as we need a square. Let the smaller of two be ‘small’. After picking smaller of two, we check if both ver[][] and hor[][] for left and up edges respectively. If they have entries for the same, then we found a subsquare. Otherwise we try for small-1.

Below is C++ implementation of the above idea.

// A C++ program to find  the largest subsquare
// surrounded by 'X' in a given matrix of 'O' and 'X'
#include<iostream>
using namespace std;

// Size of given matrix is N X N
#define N 6

// A utility function to find minimum of two numbers
int getMin(int x, int y) { return (x<y)? x: y; }

// Returns size of maximum size subsquare matrix
// surrounded by 'X'
int findSubSquare(int mat[][N])
{
    int max = 1; // Initialize result

    // Initialize the left-top value in hor[][] and ver[][]
    int hor[N][N], ver[N][N];
    hor[0][0] = ver[0][0] = (mat[0][0] == 'X');

    // Fill values in hor[][] and ver[][]
    for (int i=0; i<N; i++)
    {
        for (int j=0; j<N; j++)
        {
            if (mat[i][j] == 'O')
                ver[i][j] = hor[i][j] = 0;
            else
            {
                hor[i][j] = (j==0)? 1: hor[i][j-1] + 1;
                ver[i][j] = (i==0)? 1: ver[i-1][j] + 1;
            }
        }
    }

    // Start from the rightmost-bottommost corner element and find
    // the largest ssubsquare with the help of hor[][] and ver[][]
    for (int i = N-1; i>=1; i--)
    {
        for (int j = N-1; j>=1; j--)
        {
            // Find smaller of values in hor[][] and ver[][]
            // A Square can only be made by taking smaller
            // value
            int small = getMin(hor[i][j], ver[i][j]);

            // At this point, we are sure that there is a right
            // vertical line and bottom horizontal line of length
            // at least 'small'.

            // We found a bigger square if following conditions
            // are met:
            // 1)If side of square is greater than max.
            // 2)There is a left vertical line of length >= 'small'
            // 3)There is a top horizontal line of length >= 'small'
            while (small > max)
            {
                if (ver[i][j-small+1] >= small &&
                    hor[i-small+1][j] >= small)
                {
                    max = small;
                }
                small--;
            }
        }
    }
    return max;
}

// Driver program to test above function
int main()
{
    int mat[][N] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'O', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
                     {'O', 'O', 'X', 'O', 'O', 'O'},
                    };
    cout << findSubSquare(mat);
    return 0;
}
 */
public class LargestSubSquareSurrpoundedbyX {
}

/*

 */