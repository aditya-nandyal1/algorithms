package ArraysAndStrings;

public class MinimumValueToGetPositiveStepByStep {

    /* Task: Given an array of integers nums, you start with an initial positive value startValue.
    In each iteration, you calculate the step by step sum of startValue plus elements in nums
    (from left to right). Return the minimum positive value of startValue such that the step by
    step sum is never less than 1.*/

    /* Solution: Loop through the passed array and keep track of thr running sum. Determine when the
    sum is most negative and return one plus the absolute value of the most negative running sum.
    */

    public int minStartValue(int[] nums) {

        int startVal = 1;
        int sum = 0;

        for (int num: nums) {
            sum += num;
            startVal = Math.max(startVal, (-1*sum) + 1);
        }

        return startVal;

    }

}
