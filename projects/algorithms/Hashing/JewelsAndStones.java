package Hashing;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    /* Task: You're given strings jewels representing the types of stones that are jewels, and
    stones representing the stones you have. Each character in stones is a type of stone you have.
    You want to know how many of the stones you have are also jewels. Letters are case sensitive,
    so "a" is considered a different type of stone from "A". */

    /* Solution: Iterate through jewels, using a set to keep track of each distinct jewel. Iterate
    through stones, incrementing a counter for each stone is in the set. Return the counter.
    */

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> records = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < jewels.length(); i++) {
            records.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (records.contains(stones.charAt(i))) {
                counter++;
            }
        }

        return counter;

    }

}
