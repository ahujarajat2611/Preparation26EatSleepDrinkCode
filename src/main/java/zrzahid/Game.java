package zrzahid;

/**
 * Created by hadoop on 9/9/17.
 */
public class Game {
}

/*


#include <iostream>
#include <cmath>
#include <complex>
#include <cassert>
#include <bits/stdc++.h>
        using namespace std;

        #define all(v)        ((v).begin()), ((v).end())
        #define sz(v)       ((int)((v).size()))
        #define clr(v, d)     memset(v, d, sizeof(v))
        #define repi(i, j, n)     for(int i=(j);i<(int)(n);++i)
        #define repd(i, j, n)     for(int i=(j);i>=(int)(n);--i)
        #define repa(v)       repi(i, 0, sz(v)) repi(j, 0, sz(v[i]))
        #define rep(i, v)     repi(i, 0, sz(v))
        #define lp(i, cnt)      repi(i, 0, cnt)
        #define lpi(i, s, cnt)    repi(i, s, cnt)
        #define P(x)        cout<<#x<<" = { "<<x<<" }\n"
        #define pb          push_back
        #define MP          make_pair

        bool isWinning(int pos) {
        if (pos == 0)
        return false;  // can't move = terminal position

/// starting pos
        int moves[3] = { 1, 3, 4 };
        // play optimally: try all against his optimality
        for (int i = 0; i < 3; ++i) {
        if (pos >= moves[i] && !isWinning(pos - moves[i]))
        // opponent will lose from this move
        return true;  // ANY lose = I win
        }
        return false;  // ALL moves make opponent win
        }
        // if any of the option can give me false consition
        // then i am smart enought to make that move and win !! 1


        int main() {
        #ifndef ONLINE_JUDGE
        freopen("test.txt", "rt", stdin);
        #endif

        return 0;
        }
if i can find some position where he can lose i will
make that move ...

bool iswinning(int pos){


if(pos == 0){
    return false;
}

bool option1 = iswinning(pos-1);
bool option 2 = iswinning(pos-2)
bool option 2 = iswinning(pos-3);

// if fuck any option gives me false ( it means i will win
if(!option || !option2 || !option3){
return true;

}
return falsel




// starting positions are given
// if frmo starting position track all options  if any of the options give
me false .. bing i can win return true !!
 */