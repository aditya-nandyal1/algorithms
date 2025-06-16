package Hashing;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {

    /* Task: Given an integer array arr, count how many elements x there are, such that x + 1 is
    also in arr. If there are duplicates in arr, count them separately. */

    /* Solution: Create a set. Loop through arr and add each element to the set (sets can't have
    duplicates). Loop back through arr and determine how many elements in the array are one less than
    a number in the set.
    */


    public int countElements(int[] arr) {

        Set<Integer> elements = new HashSet<>();
        int counter = 0;
        for (int num: arr) {
            elements.add(num);
        }
        for (int num: arr) {
            if (elements.contains(num + 1)) {
                counter++;
            }
        }

        return counter;

    }

}
