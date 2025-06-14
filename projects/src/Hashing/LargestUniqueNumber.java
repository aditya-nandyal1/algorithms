package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LargestUniqueNumber {

    /* Task: Given an integer array nums, return the largest integer that only occurs once. If no
    integer occurs once, return -1.
    */

    /* Solution: Create two sets: one to record all of the unique numbers and one for the repeats.
    Iterate through the passed array. If a number is new, add it to the unique number record. If a
    number has already been seen, add it to the repeats set. Iterate through the unique number record
    and return the largest number.
    */

    public int largestUniqueNumber(int[] nums) {

        Set<Integer> numRecord = new HashSet<>();
        Set<Integer> repeats = new HashSet<>();

        for (int num: nums) {
            if (numRecord.contains(num)) {
                numRecord.remove(num);
                repeats.add(num);
            }
            else if (!repeats.contains(num)){
                numRecord.add(num);
            }
        }

        int largestUniqueNum = -1;

        for (int unique: numRecord) {
            largestUniqueNum = Math.max(largestUniqueNum, unique);
        }

        return largestUniqueNum;

    }

}
