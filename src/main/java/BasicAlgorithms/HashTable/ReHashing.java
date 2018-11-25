package BasicAlgorithms.HashTable;

/**
 * Created by hadoop on 23/10/17.
 */
public class ReHashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        int size = hashTable.length;
        int newsize = 2*size;
        ListNode[] newHashTable = new ListNode[newsize];
        // VIMPPPPPPPPP TO TAKE CARE OF THIS LOOP
        for(int i=0;i<size;i++){
            rehash(newHashTable,hashTable,i);
        }
        return newHashTable;
    }

    private void rehash(ListNode[] newHashTable, ListNode[] hashTable, int index) {

        int newsize= newHashTable.length;
        ListNode startNode = hashTable[index];
        if(startNode == null){
            return;
        }

        while (startNode!=null){
            int val = startNode.val;
            ListNode newNode = new ListNode(val);
            int hashedIndex = (val+newsize)%newsize;
            addintonewtable(newHashTable,newNode,hashedIndex);
            startNode= startNode.next;
        }
    }

    private void addintonewtable(ListNode[] newHashTable, ListNode newNode, int hashedIndex) {
        if(newHashTable[hashedIndex] == null){
            newHashTable[hashedIndex] = newNode;
            return;
        }
        else {
            ListNode oldHead = newHashTable[hashedIndex];
            newHashTable[hashedIndex] = newNode;
            newNode.next = oldHead;
        }
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}