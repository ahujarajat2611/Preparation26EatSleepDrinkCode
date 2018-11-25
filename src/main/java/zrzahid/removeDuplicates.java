package zrzahid;

import java.util.HashSet;

/// if yes consition if no condition
// take care of last case always!!
public class removeDuplicates
{
    static class node
    {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }
    static void myremoval(node n){
            HashSet<Integer> nodes = new HashSet<>();
            node curr = n;

            node prev = null;
            // dummy wud have been helpful to take care of null cases
            while (curr!=null){
                if(!nodes.contains(curr.val)){
                    // only add nodes if does nt exist in hashset
                    if(prev!=null) {
                        prev.next = curr;
                        System.out.println("prev"+prev.val);
                        System.out.println("cu"+curr.val);
                    }
                    prev = curr;
                    nodes.add(curr.val);
                }
                System.out.println("value of "+curr.val);
                curr = curr.next;
//                System.out.println("value of "+curr.val);
            }
            // once you use previous kind of approach
        // make sure you take care previous thing once you end up loop thing
        // that last case always needs to be handled outside looop thing !!!

            // very impppppppppppppp
            prev.next = null;

    }

    /* Function to remove duplicates from a
       unsorted linked list */
    static void removeDuplicate(node head)
    {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        node current = head;
        node prev = null;
        while (current != null)
        {
            int curval = current.val;

            // if current is there in map
            // point prev.next to current next soo that you skip current
            // also move current to current next always

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

    }

    /* Function to print nodes in a given linked list */
    static void printList(node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

//    curr = 1
//    prev = 2
//        nexnode = 2
//
//    1 2 1 1
    static void removalDulicates(node n) {
        node curr = n;
        while (curr != null) {
            node nextnode = curr.next;
            node prev = curr;
            while (nextnode != null) {
                if (nextnode.val != curr.val) {
                    prev = nextnode;
                    nextnode = nextnode.next;
                } else {
                    prev.next = nextnode.next;
                    nextnode = nextnode.next;
                }
            }
                curr = curr.next;
        }
    }


    static void removalDulicatesAgain(node head) {
        node dummyhead = new node(0);
        dummyhead.next = head;
        node curr = head;
        while (curr!=null){
            node forward = curr.next;
            node prev = curr;
            while (forward!=null){
                if(forward.val!=curr.val){
                    prev = forward;
                 forward = forward.next;
                }
                else {
                    prev.next = forward.next;
                    prev = forward;
                    forward = forward.next;
                }
            }
            curr = curr.next;
        }
    }


    public static void main(String[] args)
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        node start = new node(10);
        start.next = new node(10);
        start.next.next = new node(13);
        start.next.next.next = new node(14);
        start.next.next.next.next = new node(12);
        start.next.next.next.next.next = new node(11);
        start.next.next.next.next.next.next = new node(14);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        removalDulicatesAgain(start);
        //removeDuplicate(publish);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }
}
