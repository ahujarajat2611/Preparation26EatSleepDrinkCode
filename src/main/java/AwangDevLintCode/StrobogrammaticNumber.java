package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */

import java.util.*;
/*
Thoughts:
The items will be in three pattern:
1. Single digits: 0, 1, 8
2. Double digits: 00, 11, 88, 69, 96
3. More digits: adding digit-pair on front/tail sides on given digit
Note: validate that '0' appears on front/tail won't be counted.
Recursion untill n reaches 1
*/
/*
Find all strobogrammatic numbers that are of length = n.

        For example,
        Given n = 2, return ["11","69","88","96"].

        Hint:
        Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
        */


// very imp
// you should know how stringbuilder works without ide
public class StrobogrammaticNumber {
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,3,4}));
    private final List<String> singleDigitList = new ArrayList<>(Arrays.asList("0", "1", "8"));
    private final List<String> doubleDigitList = new ArrayList<>(Arrays.asList("00", "11", "88", "69", "96"));
    private final char[][] digitPair = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    public List<String> findStrobogrammatic(int n) {

        List<String> result = dfs(n);
        for (int i = 0; i < result.size(); i++) {
            String num = result.get(i);
            if ((Long.parseLong(num) + "").length() != n) {
                result.remove(i);
                i--;
            }
        }
        return result;
    }

    public List<String> dfs(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        if (n == 1) {
            return singleDigitList;
        } else if (n == 2) {
            return doubleDigitList;
        }
        final List<String> subList = dfs(n - 2);
        for (String str : subList) {
            for (int i = 0; i < digitPair.length; i++) {
                list.add(digitPair[i][0] + str + digitPair[i][1]);
            }
        }
        return list;
    }

    public List<String> dfsMine(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        if (n == 1) {
            return singleDigitList;
        } else if (n == 2) {
            return doubleDigitList;
        }
        //  final List<String> subList = dfs(n - 2);
        //for (String str : subList) {
        for (int i = 0; i < digitPair.length; i++) {
                List<String> ans = dfs(n-2);
                for(String s:ans){
                    list.add(digitPair[i][0]+s+digitPair[i][1]);
                }
                //
            //
            // list.add(digitPair[i][0] + str + digitPair[i][1]);
            }
        //}
        return list;
    }
    public void dfsMineTop(int n,StringBuilder sb,List<String> result) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            if(sb.charAt(0)!='0') {
                result.add(sb.toString());
            }
            return;
        }
        if (n == 1) {
            // inseting in the middle
            // length = 9
            //9 7 5 3 1 ( 8 ) -> 4 (0 1 2 3 ) new elementinseterd (5 6 7 8)

            sb.insert(sb.length()/2,'1');
            result.add(sb.toString());
            sb.deleteCharAt(sb.length()/2);
            sb.insert(sb.length()/2,'0');
            result.add(sb.toString());
            sb.deleteCharAt(sb.length()/2);
            sb.insert(sb.length()/2,'8');
            result.add(sb.toString());
            sb.deleteCharAt(sb.length()/2);
            return;
        }
        // options available at our end, we used array loop to define all possible options
        // hence this way !!! we moved forward !!!

        for (int i = 0; i < digitPair.length; i++) {
            sb.insert(0,digitPair[i][0]);
            sb.append(digitPair[i][1]);   // or could have sb.insert(sb.length(),digipair[i][1])
            dfsMineTop(n-2,sb,result);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        final List<String> singleDigitList = new ArrayList<>(Arrays.asList("0", "1", "8"));
        testStringBuilder();

        System.exit(1);
        StrobogrammaticNumber sb = new StrobogrammaticNumber();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> ans = new ArrayList<>();
        sb.dfsMineTop(3,stringBuilder,ans);
        System.out.println(ans);
    }
    static void testStringBuilder(){


        StringBuilder sb = new StringBuilder("rajat");
        sb.append("1");
        sb.insert(0,"2");
        // it displaces existing element to forward and thats how most insert in linkedlist or stringbuffer works
        sb.insert(0,"4");
        sb.insert(sb.length(),"3");
        System.out.println(sb);

    }
}
