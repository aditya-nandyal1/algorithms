package StacksAndQueues;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    /* Task: The next greater element of some element x in an array is the first greater element
    that is to the right of x in the same array. You are given two distinct 0-indexed integer arrays
    nums1 and nums2, where nums1 is a subset of nums2. For each 0 <= i < nums1.length, find the
    index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in
    nums2. If there is no next greater element, then the answer for this query is -1. Return an
    array ans of length nums1.length such that ans[i] is the next greater element as described
    above. */

    /* Solution: Create a stack, hash map, and array. Iterate through nums2 - in each iteration, while
    the stack is not empty and the integer from nums2 is greater than element on the top of the
    stack, pop the element on the top of the stack and map it to the integer. Finally, push the
    integer to the stack. Then, iterate through nums1 - in each iteration, if the map contains a key
    of the integer from nums1, place the corresponding value in the newly created array (otherwise,
    place a -1).
     */


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> numStack = new Stack<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] toReturn = new int[nums1.length];
        for (int num: nums2) {
            while (!numStack.isEmpty() && numStack.peek() < num) {
                numMap.put(numStack.pop(), num);
            }
            numStack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (!numMap.containsKey(nums1[i])) {
                toReturn[i] = -1;
            }
            else{
                toReturn[i] = numMap.get(nums1[i]);
            }
        }
        return toReturn;
    }

}
