package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
/*
The size of the hash table is not determinate at the very beginning.
If the total size of keys is too large (e.g. size >= capacity / 10),
we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:

size=3, capacity=4

[null, 21, 14, null]
       ↓    ↓
       9   null
       ↓
      null
The hash function is:

int hashcode(int key, int capacity) {
    return key % capacity;
}
here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.

rehashing this hash table, double the capacity, you will get:

size=3, capacity=8

index:   0    1    2    3     4    5    6   7
hash : [null, 9, null, null, null, 21, 14, null]
Given the original hash table, return the new hash table after rehashing .

Example
Given [null, 21->9->null, 14->null, null],

return [null, 9->null, null, null, null, 21->null, 14->null, null]

Note
For negative integer in hash table, the position can be calculated as follow:

C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
Python: you can directly use -1 % 3, you will get 2 automatically.
Tags Expand
LintCode Copyright Hash Table

Thoughts:
1. Loop through the hashtable[] and find longest, calcualte new capacity
2. rehash
*/
public class Rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        //Find longest size
        /*
        int longest = 0;
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            int count = 0;
            while (node != null) {
                count++;
                node = node.next;
            }
            longest = Math.max(longest, count);
        }*/
        //Calculate new capacity
        //Just to clarify, this problem asks to double the hashtable size, rather than 'longest' times longer.
        int capacity = hashTable.length * 2;
        if (capacity == hashTable.length) {
            return hashTable;
        }

        ListNode[] rst = new ListNode[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                ListNode newNode = new ListNode(node.val);
                int hCode = hashcode(newNode.val, capacity);
                if (rst[hCode] == null) {
                    rst[hCode] = newNode;
                } else {
                    ListNode move = rst[hCode];
                    while (move.next != null) {
                        move = move.next;
                    }
                    move.next = newNode;
                }
                node = node.next;
            }
        }

        return rst;
    }

    public int hashcode(int key, int capacity) {
        if (key < 0) {
            return (key % capacity + capacity) % capacity;
        } else {
            return key % capacity;
        }
    }
}
