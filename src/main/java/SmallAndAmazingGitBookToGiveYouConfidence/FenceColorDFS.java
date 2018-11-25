package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class FenceColorDFS {
    int numberofcolors = 3;
    private int mincost = Integer.MAX_VALUE;
    public int mincost(int [][]costs){
        dfs(costs,0,0,-1);
        return mincost;
    }

    // starting state and where i can reach following
    // this state keep track of prevColor as well
    // thats how you deal with things !!!

    private void dfs(int[][] costs, int index, int totalcost, int prevcolor) {
        if(index == costs.length){
            mincost = Math.min(mincost,totalcost);
            return;
        }
        else{
            for(int color = 0;color<numberofcolors;color++){
                if(color == prevcolor){
                    continue;
                }
                totalcost = totalcost + costs[index][color];
                dfs(costs,index+1,totalcost,color);
                totalcost = totalcost -costs[index][color];
            }
        }
    }
}
