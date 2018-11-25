package Algorithms6hourTraining;

import java.util.Arrays;

/**
 * Created by hadoop on 21/12/17.
 */
/*


Google :- First :- Coding challenge ( )
array of numbers :- each itration

One pattern always there for dp kind of problem
// iterate in loop and recursion .. thats the common pattern you will seeeee in dp problem
// one loop and recursion based on different different states addd cache layer and boom you are always done

 */
/*

  stones array iterate to see what match it has with laststep+1,laststep,laststep-1
  // once it reaches to certain index just apply recursion technique simply
  // it is straight forward uf you think staright forward !!!
 */

/*

Trick is all staritng points -->
 from each starting point all options --->
  backtrack to get desired ans whether its  one way,

total ways, max ways, min ways
 */

public class FrogJump {
    //int count = 0;
    public boolean canCross(int[] stones) {
        // fill cahce in the beginning
        int [][]cache = new int[stones.length][stones.length];
        for(int i=0;i<cache.length;i++){
            Arrays.fill(cache[i],-1);
        }
        return dfs(stones, 0, 0,cache);
    }

    // laststep + 1, laststep, latstep-1
    private boolean dfs(int[] stones, int start, int lastStep,int [][]cache) {
      //  count++;
      //  if(count>1000){
      //      System.exit(1);
       // }
     //   System.out.println(stones[publish]);
        // here two variables are there laststep
        //
        //
        // , and index(publish) .. lets build cahce based on taht
        // loop from

        if(cache[start][lastStep]!=-1){
             if(cache[start][lastStep] ==1 ){
                 return true;
             }
             else {
                 return false;
             }
        }
        // if have to reach exactly to lasst stone
        // not crossing the last store
        if(start>stones.length-1){
            return false;
        }
        // if reached last sstone bingo we are done !!!!!!!
        if(start == stones.length-1){
            return true;
        }
        // Finding all options from that starting point !!!!
        // much like combinations code


        // we could have hashmap to tell me states that can be considered
        // instead of loop
        // i think thats better way to deal with this problem
        // like hashmap off index , true

        // take current positon stone[start]
        // then check options stone[start]+lastjumped+1, lastjumper -1. lastjum[e true in hashmap
        // if boolean yes means valid, path can be taken, lets go ahead
        // this way if we could reach end then perfect


        /*


        usually combincation loop
        starts like
        for(int i = start ;i< length)
                recu(i+1, )

                here also it is like that
                // just that we are looping to check possible options to go
                // we are considering start but which part to recurs we are calculating
                // via loop bad bad bad method betetr to have hashmap in place to
                // do quick looop like if laststep +1 , laststep, laststep-1 exists
                if non becuase thesere are only options possible from here


                in combination we have all possible options available witn us


                for(int i = start+1, i<le;i++){

                if(valid(arra[start] + laststep){

                    then go to that i

             looping to check valididy, rather should have hashmap to check validity
             as we have done in nqueeen and other backtracking options

         */


        //
        for(int i=start+1;i<stones.length;i++){
            int newstep = lastStep-1;
            if(stones[start] + newstep == stones[i]) {
                // passing i so that next steps check further i and laststep as well
                if (dfs(stones, i, newstep,cache)) {
                    cache[i][newstep] = 1;
                    return true;
                }
            }
            newstep = lastStep + 1;
            if(stones[start] + newstep == stones[i]) {
                if (dfs(stones, i, newstep,cache)) {
                    cache[i][newstep] = 1;
                    return true;
                }
            }
            newstep = lastStep;
            if(stones[start] + newstep == stones[i]) {
                if (dfs(stones, i, newstep,cache)) {
                    cache[i][newstep] = 1;
                    return true;
                }
            }
        }
        // after all options we could not find return false !!!

        cache[start][lastStep] = 0;
        return false;
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
/*

Trick is all staritng points --> from each starting point all options ---> backtrack to get desired ans whether its  one way,
total ways, max ways, min ways
 */