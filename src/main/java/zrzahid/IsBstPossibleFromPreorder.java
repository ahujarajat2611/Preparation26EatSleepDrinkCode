package zrzahid;

public class IsBstPossibleFromPreorder {
    public static void main(String args[]){
        int[] preorder = {40, 30, 35, 20, 80};//{6,3,0,5,4,8,7,9};//{3,2,5,1,7};
        System.out.println(isBstPossible(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, preorder.length-1));
    }

    /*
    li is root of current subtree
    ri is the column of the last element in the current subtree
    min, max range for the elements of current subtree
     */
    private static boolean isBstPossible(int[] preorder, int min, int max, int li, int ri){
        if (li==ri && preorder[li]>min && preorder[li]<max){ // if single node subtree...
            return true;
        }
        if (preorder[li]<=min || preorder[li]>=max ){ // if node value out of range
            return false;
        }
        int lsi = preorder[li+1]<preorder[li]?li+1:-1; // left subtree root column (-1 if no left subtree exits for node li)
        int rsi = findNextHigherElementIndex(preorder, li, ri); // right subtree root column (-1 if no right subtree exists for node li)

        boolean isLeftValid = (lsi==-1 || isBstPossible(preorder, min, preorder[li], lsi, rsi-1>lsi?rsi-1:lsi));
        boolean isRightValid =  (rsi==-1 || isBstPossible(preorder, preorder[li], max, rsi, ri));
        return isLeftValid && isRightValid;
    }

    private static int findNextHigherElementIndex(int[] preorder, int li, int ri){
        int x = -1; // -1 if no higher element on right side of li
        for (int i = li+1; i <= ri ; i++) {
            if (preorder[i]>preorder[li]){
                x = i;
                break;
            }
        }
        return x;
    }
}

/*
The first thing we can consider here that for preorder traversal row,
 if at any Point on right side of row we
 find greater element than current element and
 if any element after that is smaller element,
  we should consider that BST is not possible from that very preorder traversal given.

e.g: arr[] = {40,30,35,20,80,100} not possible to build valid BST.

Explanation:

root 30
40 35

Here when we publish building the tree 40 becomes the root of the BST, Now as we proceed
 30 goes in left subtree and now we find next greater of
 30 which is 35, as we know for any lower or smaller element to be in
 the left subtree of 30 should must have been between 30 and its next greater i.e 35 here. So, as we traverse forward we find
 20 which can't fit in left of 30 as it
  is after the next greater element and certainly not as child of 35 as it will violate the BST property (i.e any right subtree element must have greater value always in comparison to root). Thus,valid BST can't be made.

Now, to solve this we can use stack as we use it to
find the next greater element in an row Code for next greater element.
Here we have to just ensure after having the next greater no element comes smaller than that after.

In the code we initially take root as INT_MIN lowest possible value, If the root is anytime lower than current element we return false. While the current element is greater than the element at the top of stack we pop it and set root as the popped element. And we push the current element into the stack for further comparison.

bool check(int *arr, int n)
{
stack<int> s;
// neginning root has to be INT_MIN ..
// later if value <root retyurn false
// in the loop keep poppping all left elements until you hit root !! once you
// plan to go right !!
int root=INT_MIN;
for(int i=0;i<n;++i)
{
 // check if there is anomly
    if(arr[i]<root)
        return false;

     // decreasing stack .. most cases will get solved by this !!!
    while(!s.empty() && arr[i]>s.top())
    {
        root=s.top();
        s.pop();
    }
    // later we push it to stack normal stack flow

    s.push(arr[i]);
}
return true;
}
 */