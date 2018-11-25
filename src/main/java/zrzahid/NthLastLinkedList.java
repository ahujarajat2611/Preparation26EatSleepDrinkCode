package zrzahid;

/**
 * Created by hadoop on 9/9/17.
 */
public class NthLastLinkedList {
    public static void main(String[] args) {

    }
    private class Node{
       private  int x ;
       private Node next;
    }
    public Node getNodeNth(Node node, int k){
        Node curr = node;
        Node follower = node;
        // traverse top k slements first !!!!!
        for( int i=0;i<k;i++){
            if(curr == null) return null;
            curr = curr.next;
        }
        // here we started dealingin
        // next pointer rather than curren.next
        while (curr.next!=null){
            curr = curr.next;
            follower= follower.next;
        }
        return follower;
    }
    public int ones(int x){
        int sum = 0;
        while(x>0){
            sum = sum + x&1;
        }
        return sum;
    }
}
