package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 19/9/17.
 */
public class ConnectedComponents {
    DisjointSet disJoint = new DisjointSet();
    public static int[][]DIRS = {{1,0},{0,1},{0,-1},{-1,0}};
    List<Integer> numIslands(int n,int m,Point []operatos){
        List<Integer> result = new ArrayList<>();
        boolean [][] islands = new boolean[n][m];
        int count =0;
        for(Point p:operatos){
            if(!islands[p.x][p.y]){
                islands[p.x][p.y]=true;
                int id = getId(n,p.x,p.y);
                disJoint.makeSet(id);
                long root = disJoint.findSet(id);
                for(int i=0;i<4;i++){
                    int newx = p.x+DIRS[i][0];
                    int newy = p.y +DIRS[i][1];
                    if(!isValid(newx,newy,n,m) && islands[newx][newy])continue;
                    long newRoot = disJoint.findSet(getId(n,newx,newy));
                    if(root!=newRoot){
                        count--;
                        disJoint.union(root,newRoot);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private boolean isValid(int newx, int newy,int n,int m) {
        if(newx>=0 && newx<n && newy>0 && newy <m){
            return true;
        }
        return false;
    }

    private int getId(int m,int x, int y) {
        return x*m+y;
    }

    private class Point{
        int x;
        int y;
    }
}
