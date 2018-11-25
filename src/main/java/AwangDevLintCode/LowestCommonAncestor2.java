package AwangDevLintCode;

/**
 * Created by hadoop on 5/2/18.
 */
/*
Lowest Common Ancestor II

Given the root and two nodes in a Binary Tree.
Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself.
The root's parent is null.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

Tags Expand
LintCode Copyright Binary Tree
*/

/*
    Thoughts:
    我之前的做法也是蛮彪悍的，HashSet只存所需要的parent, 其实算是一个优化，更节省空间。
    12.11.2015.
    今天这个再来实现一个普通的做法，存在两个list里面。有parent的题目本身比没parent更简单。
    从头遍历两个list.
    1. 一旦分叉，分叉口的parent就是要找的。
    2. 如果两个list一直相等，那他们就是同一个node

    border case: if both null, just return null.
    if only 1 is null, let one of the node be ancestor; since null can be anywhere.
*/
import java.util.*;
public class LowestCommonAncestor2 {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,ParentTreeNode B) {
        if (root == null || (A == null && B == null)) {
            return null;
        } else if (A == null || B == null) {
            return A == null ? B : A;
        }
        //Populate listA, listB
        ArrayList<ParentTreeNode> listA = new ArrayList<ParentTreeNode>();
        ArrayList<ParentTreeNode> listB = new ArrayList<ParentTreeNode>();

        while (A != root) {
            listA.add(0, A);
            A = A.parent;
        }
        listA.add(0, A);
        while (B != root) {
            listB.add(0, B);
            B = B.parent;
        }
        listB.add(0, B);

        int size = listA.size() > listB.size() ? listB.size() : listA.size();

        for (int i = 0; i < size; i++) {
            if (listA.get(i) != listB.get(i)) {
                return listA.get(i).parent;
            }
        }

        // if we could not then last one
        return listA.get(size - 1);
    }
}

class ParentTreeNode {
      public ParentTreeNode parent, left, right;
  }