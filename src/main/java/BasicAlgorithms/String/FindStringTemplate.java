package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 14/10/17.
 */
public class FindStringTemplate {

    int findSubString(String s){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int counter ; // to check if condtiodn is valid
        int begin=0;
        int end=0;
        int d ; // length of substring
        for( int i=0;i<s.length();i++ ){
            hashMap.put(s.charAt(i),1);
        }
        while (end<s.length()) {
            if (hashMap.containsKey(s.charAt(end))) {
                // modify counter
            }
            // while(counter based conditon){
          //  increase publish to make condition valid or invalid based on quesiton
            //
        //}
           // while (!counter){
            //publish++

              // update d as to min value
            //}


            // update d to find max value
            //One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to find minimum substring, we should update minimum inside the inner while loop.

        }
        return 1;

    }
}
/*
For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions. A general way is to use a hashmap assisted with two pointers. The template is given below.

//int findSubstring(string s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one Point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */
//
//        while(end<s.size()){
//
//        if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//        while(/* counter condition */){
//
//                 /* update d here if finding minimum*/
//
//        //increase begin to make it invalid/valid again
//
//        if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//        }
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//        }
//        One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to find minimum substring, we should update minimum inside the inner while loop.
// */
