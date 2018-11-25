package AwangDevLintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 13/10/17.
 */
/*
Thoughts trick is always find ... first if two nodes belong to same parent or not ..
if they belong to same parent already .....if parents are not same then make it same since they are adjacent
parent needs to be adjaent
 if(disjointSet.findset(newx*n+newy)!=null){
 disjointSet.Union(index,newx*n+newy);



 U need to create set for all1 possible in the matrix ....
 idea in unoin find  is first to crete setsssss nodesssssss very imp and then work accorindgly
 before making union always check if nodes are connected or not .. .

}
 */
public class NumberOfIslands2 {
    public static void main(String args[]){
        int pos[][] = {{0,0}, {0,1}, {1,2}, {2,1}};
        System.out.println(numIslands2(3,3,pos));
    }
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int dirx[] = {1,-1,0,0};
        int diry[] = {0,0,1,-1};
        DisjointSet<Integer> disjointSet =new DisjointSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            int x = positions[i][0];
            int y = positions[i][1];
            int index = x*n+y;
            disjointSet.makeset(index);
            // first we make new set ... and then check its neighbours

            for(int k=0;k<4;k++){
                int newx = x+ dirx[k];
                int newy = y + diry[k];
                if(!isValid(newx,newy,m,n)){
                    continue;
                }
                if(disjointSet.findset(newx*n+newy)!=null){
                    disjointSet.Union(index,newx*n+newy);
                }
            }
            res.add(disjointSet.getCount());
        }
        return res;
    }

    private static boolean isValid(int newx, int newy,int m,int n) {
        if(newx>=0 && newx<m && newy>=0 && newy<n){
            return true;
        }
        return false;
    }
}