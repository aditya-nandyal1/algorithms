package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    /* Task: Given a binary array nums, return the maximum length of a contiguous subarray with
    an equal number of 0 and 1.
    */

    /* Solution: Iterate through an array, adding one to a variable called sum for each one
    encountered and subtracting one from sum for each zero encountered. When sum == 0, that means
    that there are an equal number of 0s and 1s, so if the current subarray (of length i+1) is longer
    than maxLength, update it accordingly. If sum != 0, check if we have seen the sum before. If we
    have, then the difference between i and the index of the last place with that sum is the length
    of a subarray with an equal number of 0s and 1s. If this subarray is longer than maxStreak, update
    maxStreak accordingly.
    */

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            }
            else{
                sum--;
            }
            if (sum == 0){
                maxLength = Math.max(maxLength, i + 1);
            }
            else{
                if (!records.containsKey(sum)){
                    records.put(sum, i);
                }
                else{
                    maxLength = Math.max(maxLength, i - records.get(sum));
                }
            }
        }
        return maxLength;
    }

}
