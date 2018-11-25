package DSA.Common;

import DSA.nodes.DLLNode;
import DSA.nodes.ListNode;

/**
 * Created by hadoop on 13/2/18.
 */
public class CommonUtil {
    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void swap(char a[],int i,int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void swap(int[][] a, int x1, int y1, int x2, int y2) {
        int temp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = temp;
    }
    public static void swapLeftRight(DLLNode<Integer> cur) {
        DLLNode<Integer> temp = cur.next;
        cur.next = cur.prev;
        cur.prev = temp;
    }
    public static void swap(ListNode<Integer> a, ListNode<Integer> b) {
        a.data = a.data ^ b.data;
        b.data = a.data ^ b.data;
        a.data = a.data ^ b.data;
    }
}
