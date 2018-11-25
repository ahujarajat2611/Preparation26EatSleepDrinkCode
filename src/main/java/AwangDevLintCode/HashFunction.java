package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
In data structure Hash,
hash function is used to convert a
string(or any other type)
into an integer smaller than hash size
and bigger or equal to zero. The objective of
designing a hash function is to "hash" the key as unreasonable as possible.
A good hash function can avoid collision as less as possible.
A widely used hash function algorithm is using a magic number 33,
consider any string as a 33 based big integer like follow:

hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33^1 + ascii(d)*33^0) % HASH_SIZE

                              = (97* 33^3 + 98 * 33^2  + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

here HASH_SIZE is the capacity of the hash table
(you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).

Given a string as a key and the size of hash table, return the hash value of this key.



Example
For key="abcd" and size=100, return 78

Clarification
For this problem, you are not necessary to design your own hash algorithm
or consider any collision issue, you just need to implement the algorithm as described.

Tags Expand
Hash Table

*/
/*
Thinking process:
Use given hash function.
However, need to consider integer overflow.
A simple way: save it as a long during calculation. Then return a (int).

*/

public class HashFunction {
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key.length == 0) {
            return 0;
        }
        long hashRst = 0;
        for (int i = 0; i < key.length ; i++) {
            hashRst = hashRst * 33 + (int)(key[i]);
            hashRst = hashRst % HASH_SIZE;
        }
        /// keep taking mod !!!
        // hashrest = hashrest*base + number
        // hashrest%mod!!
        return (int)hashRst;
    }
}
