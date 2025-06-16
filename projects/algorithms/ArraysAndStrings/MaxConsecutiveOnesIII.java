package ArraysAndStrings;

public class MaxConsecutiveOnesIII {

    /* Task: Given a binary array nums and an integer k, return the maximum number
    of consecutive 1's in the array if you can flip at most k 0's.*/

    /* Solution: Use a left and right pointer to establish a window within the array. While k or less
    0's have been flipped, just increment the right pointer and update the streak variable.
    If more than k 0's have been flipped, increment the left pointer until enough 0's are removed
    from the window before incrementing the right pointer and updating the streak variable.
    */

    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int longestStreak = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0){
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            longestStreak = Math.max(longestStreak, right-left+1);
            right++;
        }

        return longestStreak;

    }

}
