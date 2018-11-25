package BasicAlgorithms.Array;

/**
 * Created by hadoop on 7/1/18.
 */
public class RecoverSortedArray2 {
}

/*
Given a rotated sorted array, recover it to sorted array in-place.



Hints:
3-time reverse:
total reverse: [4,5,6,7,1,2,3] => [3,2,1,7,6,5,4]
reverse first part: [3,2,1,7,6,5,4] => [1,2,3,7,6,5,4]
reverse second part: [1,2,3,7,6,5,4] => [1,2,3,4,5,6,7]


Python:
class Solution:
    """
    @param nums: The rotated sorted array
    @return: nothing
    """
    def recoverRotatedSortedArray(self, nums):
        # write your code here
        if nums is None or len(nums) == 0:
            return []

        n = len(nums)
        minValue = min(nums)
        k = 0
        for i in range(len(nums)):
            if nums[i] == minValue:
                k = i

        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, n - k - 1)
        self.reverse(nums, n - k, n - 1)

    def reverse(self, a, l, r):
        if a is None or len(a) == 0:
            return []

        while l < r:
            tmp = a[l]
            a[l] = a[r]
            a[r] = tmp
            l += 1
            r -= 1
 */