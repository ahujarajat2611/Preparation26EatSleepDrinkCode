package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class TwoPointers {
/*
class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstringTwoDistinct(self, s):
        counts = [0] * 256
        i = maxLen = numChar = 0

        for j in range(len(s)):
            if counts[ord(s[j])] == 0:
                numChar += 1

            counts[ord(s[j])] += 1

            while i < len(s) and numChar > 2:    # more than 2 distinct in the window
                counts[ord(s[i])] -= 1
                if counts[ord(s[i])] == 0:
                    numChar -= 1
                i += 1

            maxLen = max(maxLen, j - i + 1)      # get the max value each time

        return maxLen
 */
/*
Rotate List
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def rotateRight(self, head, k):
        if not head or not head.next or k == 0:
            return head

        n = self.getLen(head)

        k = k % n

        if k == 0:
            return head

        dummy = ListNode(0)
        dummy.next = head
        cur = head

        for i in range(k):
            cur = cur.next

        while cur and cur.next:
            head = head.next
            cur = cur.next

        newHead = head.next
        cur.next = dummy.next
        head.next = None

        return newHead

    def getLen(self, head):
        n = 0
        while head:
            head = head.next
            n += 1

        return n


 */
/*
class Solution:
    # @param {ListNode} head
    # @param {integer} x
    # @return {ListNode}
    def partition(self, head, x):
        node1, node2 = ListNode(0), ListNode(0)
        p1, p2 = node1, node2

        while head:
            if head.val < x:
                p1.next = head
                p1 = p1.next
            else:
                p2.next = head
                p2 = p2.next

            head = head.next

        p2.next = None
        p1.next = node2.next

        return node1.next
 */

    int maxWater(int []a){
        int left =0;
        int right = a.length-1;
        // max water between lines of histgram
        // if left hieght is smaller move

        int maxarea=0;
        while (left<right){
            // math.min will take care of both the cases
            // perfect
            // keep track of max area
            maxarea = Math.max(maxarea,(right-left) * Math.min(a[left],a[right]));
            if(a[left]<a[right]){
                // if left is lower lets move this pointer
                left++;
            }
            else {
                right--;
            }
        }

        return maxarea;
    }

    /*

Creative Commons License

This tutorial page by Jikai Tang is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
[LEETCODE 209] MINIMUM SIZE SUBARRAY SUM
6/18/2015 0 COMMENTS

Link:
https://leetcode.com/problems/minimum-size-subarray-sum/

Question:
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

Solution 1: Sliding window(Two Pointers)
When sum >= target, move the left pointer forward.

Python:
class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        total = l = 0
        res = len(nums) + 1

        for r, elem in enumerate(nums):
            total += elem
            while total >= s:
                res = min(res, r - l + 1)
                total -= nums[l]
                l += 1

        return res if res <= len(nums) else 0
     */

    /*

        def removeDuplicates(self, nums):
        n = len(nums)
        if n < 2:
            return n

        tail = 0
        for i in range(1, n):
            if nums[tail] != nums[i]:
                tail += 1
                nums[tail] = nums[i]

        return tail + 1
     */
// removal of duplicates from sorted array
    // tail technieuq
    int max2dup(int []nums){

        int tail = 1;
        for(int i=2;i<nums.length;i++){
            if(nums[tail]!= nums[i] || nums[tail-1]!=nums[i]){
                nums[++tail] = nums[i];
            }
        }
        return tail+1;
    }
    int max1dup(int []num){
        int tail = 0;
        for(int i=1;i<num.length;i++){
            if(num[tail]!=num[i]){
                num[++tail] = num[i];
            }
        }
        return tail+1;
    }
}
