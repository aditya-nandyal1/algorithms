package ArraysAndStrings;

public class ReverseString {

    /* Task: Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory. */

    /* Solution: Use a left pointer and a right pointer, swap values in the array until the two
    * pointers meet.*/

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }
}
