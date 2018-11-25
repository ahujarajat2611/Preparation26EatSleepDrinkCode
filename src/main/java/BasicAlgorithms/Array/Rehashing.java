package BasicAlgorithms.Array;

/**
 * Created by hadoop on 24/2/18.
 */
public class Rehashing {
    /**
     * Definition for ListNode
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
        /**
         * @param hashTable: A list of The first node of linked list
         * @return: A list of The first node of linked list which have twice size
         */
        public ListNode[] rehashing(ListNode[] hashTable) {
            if (hashTable == null || hashTable.length == 0) {
                return hashTable;
            }
            int capacity = hashTable.length;
            int newCapacity = 2 * capacity;
            ListNode[] newHashTable = new ListNode[newCapacity];
            for (int i = 0; i < capacity; i++) {
                ListNode ln = hashTable[i];
                while (ln != null) {
                    int code = hashcode(ln.val, newCapacity);
                    insertToHashTable(newHashTable, code, ln.val);
                    ln = ln.next;
                }
            }
            return newHashTable;
        }
        public int hashcode(int key, int capacity) {
            int hash;
            if (key < 0) {
                hash = (key % capacity + capacity) % capacity;
            } else {
                hash = key % capacity;
            }
            return hash;
        }
        private void insertToHashTable(ListNode[] hashTable, int code, int value) {
            if (code < hashTable.length) {
                ListNode ln = hashTable[code];
                if (ln == null) {
                    hashTable[code] = ln = new ListNode(value);
                } else {
                    while (ln.next != null) {
                        ln = ln.next;
                    }
                    ln.next = new ListNode(value);
                }
            }
        }

        public static void main(String[] args) {
            Rehashing s = new Rehashing();
            ListNode[] lsn = new ListNode[3];
            lsn[0] = null;
            lsn[1] = null;
            lsn[2] = new ListNode(29);
            lsn[2].next = new ListNode(5);
            ListNode[] newLsn = s.rehashing(lsn);
        }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
