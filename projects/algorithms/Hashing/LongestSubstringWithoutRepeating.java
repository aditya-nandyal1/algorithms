package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    /* Task: Given a string s, find the length of the longest substring without duplicate characters. */

    /* Solution: Iterate a right pointer through s. Upon finding a duplicate letter between l and r,
    increment the left pointer to close the window until it has no duplicates or l == r. Return the
    size of the largest window found.
    */

    public int lengthOfLongestSubstring(String s) {
        Set<String> records = new HashSet<>();
        int longestSub = 0;
        int r = 0;
        int l = 0;
        while (r < s.length()) {
            while (l < r && records.contains(s.substring(r, r+1))) {
                records.remove(s.substring(l, l+1));
                l++;
            }
            records.add(s.substring(r, r+1));
            longestSub = Math.max(longestSub, r-l+1);
            r++;
        }

        return longestSub;
    }

}
