package ArraysAndStrings;

public class MaximumAverageSubarray {

    /* Task: You are given an integer array nums consisting of n elements, and an integer k.
    Find a contiguous subarray whose length is equal to k that has the maximum average value
    and return this value.*/

    /* Solution: Determine the average value of the first k elements of the array. From there, see
    how the average value changes as the leftmost element of the subarray is replaced by the next
    element to the right. After iterating through the entire array, return the greatest found
    average value.
    */

    public double findMaxAverage(int[] nums, int k) {

        int left = 0;
        int right = 0;
        double runningSum = 0.0;

        while (right < k) {
            runningSum += nums[right];
            right++;
        }

        double maxAvg = runningSum/k;

        while (right < nums.length) {
            runningSum = runningSum + nums[right] - nums[left];
            left++;
            right++;
            maxAvg = Math.max(maxAvg, runningSum/k);
        }

        return maxAvg;

    }

}
