package Hashing;

public class MissingNumber {

    /* Task: Given an array nums containing n distinct numbers in the range [0, n], return the only
    number in the range that is missing from the array. */

    /* Solution: Create a boolean array that is one bigger than nums. Loop through nums and set the
    boolean array to true at the index of each existing number. Loop back through the boolean array
    and determine the index of the element in the array that is false.
    */

    public int missingNumber(int[] nums) {
        boolean[] existingNums = new boolean[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            existingNums[nums[i]] = true;
        }

        for (int j = 0; j < existingNums.length; j++){
            if(existingNums[j] == false){
                return j;
            }
        }

        return -1;

    }

}
