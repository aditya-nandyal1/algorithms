package ArraysAndStrings;

public class SquaresOfSortedArray {

    /* Task: Given an integer array nums sorted in non-decreasing order, return an array of the
     squares of each number sorted in non-decreasing order. */

    /* Solution: Use two pointers to check if the absolute value of the rightmost or leftmost
     array value is the biggest. Using this information, add the square of the biggest value to the
     end of a newly created array. Continue this pattern until every array value is accounted for,
     decrementing the right pointer and incrementing the left pointer appropriately.
    */

    public int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int currIndex = nums.length - 1;
        int[] squares = new int[nums.length];

        while (currIndex >= 0) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])){
                squares[currIndex] = (int) Math.pow(nums[right], 2);
                right--;
            }
            else{
                squares[currIndex] = (int) Math.pow(nums[left], 2);
                left++;
            }
            currIndex--;
        }

        return squares;

    }

}
