package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
In the room where the princess(p) is imprisoned, the knight(k) needs at least 1 HP. As the note suggests, "Any room can contain threats or power-ups", so the minimumHP needed is 1 + dungeon[m -1][n - 1]. What if the room contains power-ups? That means the minimumHP k needs in that room is 1.

Note that if we need more HP
, we need to add the points that will be deducted when fighting with the demons.
And since that point is negative, we need to deduct that point.


 If there is a power-up, that number will be negative,
  and we take the minimum point needed,
  which is 1. Take the bottom right room as the example:
 minHP[i][n - 1] = Math.max(minHP[i + 1][n - 1] - dungeon[i][n - 1], 1);

The boundary can be calculated by deducting dungeon[m - 1][j] (dungeon[i][n - 1]) from minHP[m - 1][j + 1] (minHP[ i + 1][n - 1]) and taking the minimum between the result and 1.

For the rooms in the middle, since k can only go right and down, we take the minimum between minHP[i + 1][j] and minHP[i][j + 1], i.e., get the minimum HP in order to enter the next room.

minHP[i][j] = Math.min(minHP[i + 1][j], minHP[i][j + 1]) - dungeon[i][j];
minHP[i][j] = (minHP[i][j] <= 0) ? 1 : minHP[i][j];

When we reach minHP[0][0], we get the minimum HP needed for k.
 */
public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null)
            throw new NullPointerException("Null dungeon...!");
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            System.out.println("Well, apparently there is no threat...");
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHP = new int[m][n];
        minHP[m - 1][n - 1] = Math.max(-dungeon[m - 1][n - 1] + 1, 1);
        for (int i = m - 2; i >= 0; i--) {
            minHP[i][n - 1] = Math.max(minHP[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int j = n - 2; j >= 0; j--) {
            minHP[m - 1][j] = Math.max(minHP[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                minHP[i][j] = Math.min(minHP[i + 1][j], minHP[i][j + 1]) - dungeon[i][j];
                minHP[i][j] = (minHP[i][j] <= 0) ? 1 : minHP[i][j];
            }
        }
        return minHP[0][0];

    }


    public int calculateMinimumHPMine(int[][] dungeon) {
        if(dungeon == null){
            return 0;
        }
        if(dungeon.length ==0 || dungeon[0].length ==0){
            return 0;
        }

        int minpowerrequired [][] = new int[dungeon.length][dungeon[0].length];

        int m = dungeon.length;
        int n = dungeon[0].length;
        minpowerrequired[m-1][n-1] = -1*dungeon[m-1][n-1]+1;

        for(int i = m-2;i>=0;i--){
            minpowerrequired[i][n-1] = Math.max(minpowerrequired[i+1][n-1] -dungeon[i][n-1],1);
        }
        for(int i = n-2;n>=0;n--){
            minpowerrequired[m-1][i] = Math.max(minpowerrequired[m-1][i+1] -dungeon[m-1][i],1);
        }

        for(int i= m-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                minpowerrequired[i][j] = Math.min(minpowerrequired[i+1][j],minpowerrequired[i][j+1])-dungeon[i][j];
                if(minpowerrequired[i][j]<=0){
                    minpowerrequired[i][j] = 1;
                }
            }
        }
        return minpowerrequired[0][0];
    }
}