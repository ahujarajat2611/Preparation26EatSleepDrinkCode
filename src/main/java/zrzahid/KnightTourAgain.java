package zrzahid;

/**
 * Created by hadoop on 7/9/17.
 */

public class KnightTourAgain
{
    private static final int N = 8;
    private int soln[][];

    public KnightTourAgain()
    {
        soln = new int[N][N];
    }

    private boolean isSafe(int x, int y)
    {
        if (x >= 0 && x < N && y >= 0 && y < N && soln[x][y] == -1)
            return true;
        return false;
    }

    private void printSolution()
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                System.out.print("  " + soln[x][y]);
            }
            System.out.println();
        }
    }

    private boolean solveKTUtil(int x, int y, int movei, int xMove[],int yMove[])
    {
        /// keepig track of all starting positions filled !!!
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
        // no starting position left .. cool lets return true which will get further
        // returned !!!

        // these are options ... starting positions being passed ..
        // some times you need to make starting positions in dp problems
        // and there onwards all possible options !!!
        // thats how you can look at things !!!

        for (k = 0; k < N; k++)
        {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y))
            {
                soln[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, xMove, yMove))
                    return true;
                soln[next_x][next_y] = -1;
            }
        }
        return false;
    }

    public boolean solveKnightTour()
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                soln[x][y] = -1;
            }
        }
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        soln[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, xMove, yMove))
        {
            System.out.println("the solution does not exist");
            return false;
        }
        else
        {
            printSolution();
        }
        return true;
    }

    public static void main(String... arg)
    {
        KnightTourAgain knightTour = new KnightTourAgain();
        System.out.println("the solution is");
        knightTour.solveKnightTour();
    }
}