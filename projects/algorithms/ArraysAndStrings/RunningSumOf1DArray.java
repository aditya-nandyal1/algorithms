package ArraysAndStrings;

public class RunningSumOf1DArray {

    /* Task: Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums. */

    /* Solution: Instantiate a variable to keep track of the running sum. Create a new integer array.
    Loop through the passed array, adding each element to the running sum and updating the new array
    with the running sum as of that spot in the loop.
    */

    public int[] runningSum(int[] nums) {

        int sum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        return sums;
    }

}
