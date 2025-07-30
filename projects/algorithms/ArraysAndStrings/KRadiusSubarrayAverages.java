package ArraysAndStrings;

public class KRadiusSubarrayAverages {

    /* Task:You are given a 0-indexed array nums of n integers, and an integer k. The k-radius
    average for a subarray of nums centered at some index i with the radius k is the average of
    all elements in nums between the indices i - k and i + k (inclusive). If there are less than
    k elements before or after the index i, then the k-radius average is -1. Build and return an
    array avgs of length n where avgs[i] is the k-radius average for the subarray centered at
    index i. The average of x elements is the sum of the x elements divided by x, using integer
    division. The integer division truncates toward zero, which means losing its fractional part.*/

    /* Solution: Create a sum array and an averages array. Loop through the passed nums array, keeping
    track of the running sum of the elements and updating the sum array with the running sum as of
    that spot in the loop. Afterward, place -1 in the averages array for every element that is within
    k distance of the beginning or end of the array. For the other elements, use the sum array to
    determine the sum of the elements between i-k and i+k (by subtracting sum[i+k] and sum[i-k]
    and adding the value at nums[i-k]). Finally, divide the determined sum at each index by the span
    and place the corresponding average values in the averages array.
    */

    public int[] getAverages(int[] nums, int k) {

        long[] sums = new long[nums.length];
        int[] avgs = new int[nums.length];
        long sum = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }


        for (int i = 0; i < nums.length ; i++) {
            if (i < k || nums.length - i <= k){
                avgs[i] = -1;
            }
            else{
                avgs[i] = (int)((sums[i + k] - sums[i-k] + nums[i-k])/(2*k + 1));
            }
        }

        return avgs;
    }

}
