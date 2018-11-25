package zrzahid;

import java.util.HashSet;

/**
 * Created by hadoop on 10/9/17.
 */
public class Depulicate {
    private class Node{
        int val;
        Node next;
    }

//    1,2,1,4
//1111;
//    nodes {1,2}
//    curr = 4;
//    prev = 2;
//4 5 5 6 {4,5,}
    // watta fuck method of deduplicatine the linkedlist
    // prevy or dummy and hashSet if it has been visited or not !!!
    public void deduplicate(Node n){
        HashSet<Integer> nodes = new HashSet<>();
        Node curr = n;

        Node prev = null;
        while (curr!=null){
            if(!nodes.contains(curr.val)){
                if(prev!=null) {
                    prev.next = curr;
                }
                prev = curr;
                nodes.add(curr.val);
            }
            curr = curr.next;
        }

        // once you loop through
        // chech for missed ocntion s
        // 90% you have to do cleapnup work after loop for sure

        // in the end prev should point to NUll else problem ho jaayegi !!
        // MUST MUST MUST
        // ALL PREV KIND OF QUESTIONS CHECK FOR CONDITIONS
        // AFTER LOOP SURELLY  YOU WOULD HAVE MISS THE TRICK !!!
        prev.next = null ;
    }
}
