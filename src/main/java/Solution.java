import java.util.*;
import java.io.*;
public class Solution {
    public static class LinkedListNode{
        String val;
        LinkedListNode next;
    
        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    };
    
    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }
    static int find(LinkedListNode list, LinkedListNode sublist) {
        LinkedListNode firstList = list;
        int index = 0;
        while (firstList!=null){
            if(firstList.val == sublist.val){
                LinkedListNode first = firstList;
                LinkedListNode second = sublist;
                while (second!=null && first!=null && second.val == first.val){
                    second = second.next;
                    first = first.next;
                }
                if(second == null){
                    return index;
                }
            }
            firstList = firstList.next;
            index++;
        }
        return -1;

    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _list_size = Integer.parseInt(in.nextLine()), _list_i;
        String _list_item;
        LinkedListNode _list = null;
        for(_list_i = 0; _list_i < _list_size; _list_i++) {
            try {


    _list_item = in.nextLine();
} catch (Exception e) {
        _list_item = null;
        }
        _list = _insert_node_into_singlylinkedlist(_list, _list_item);
        }


        int _sublist_size = Integer.parseInt(in.nextLine()), _sublist_i;
        String _sublist_item;
        LinkedListNode _sublist = null;
        for(_sublist_i = 0; _sublist_i < _sublist_size; _sublist_i++) {
        try {
        _sublist_item = in.nextLine();
        } catch (Exception e) {
        _sublist_item = null;
        }
        _sublist = _insert_node_into_singlylinkedlist(_sublist, _sublist_item);
        }

        res = find(_list, _sublist);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
        }
}


// 10 to 12
// i have 14 hours of coding
// 14 hours i have so better you do it all
//