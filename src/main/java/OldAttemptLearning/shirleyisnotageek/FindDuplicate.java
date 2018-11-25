package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
The most straightforward way
is to utilize pigeon hole theorem: keep swapping
elements so that
nums[i] = [i] until we find
nums[nums[i]] = nums[i], then nums[i] is the duplicate one. If everything is in place, return nums[0].

BUT, the question requires no modification to the array, and no extra space. So we cannot use swap or construct an external array. There is a very interesting solution online that utilizes the solution in find cycle in linkedlist problem. So we consider each index as a list node, and the next node is its element, i.e., i -> nums[i]. Now we can construct a linked list in our mind. Since there is a duplicate node, we know there must exist a cycle. Now we can use the solution of Linked list Cycle II to solve the problem.
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // startinn frmmo 0 index and keep going
        // until we hit same fale
        // 0 index acting like head
        //
        int slow = nums[0], fast = nums[nums[0]], t = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicateagain(int[] nums) {

        int index = 0;
        int slow = nums[index];
        int fast = nums[nums[index]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
