package Hashing;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    /* Task: Given two strings ransomNote and magazine, return true if ransomNote can be constructed
    by using the letters from magazine and false otherwise. Each letter in magazine can only be used
    once in ransomNote. */

    /* Solution: Iterate through magazine while using a map to keep track of the frequency of its
     letters. Iterate through ransomNote, returning false if the map does not contain a letter or
     any more instances of a letter. If you make it past the loop, return true.
    */

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> magLets = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++){
            magLets.put(magazine.substring(i, i+1), magLets.getOrDefault(magazine.substring(i, i+1), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++){
            if (!magLets.containsKey(ransomNote.substring(i, i+1)) || magLets.get(ransomNote.substring(i, i+1)) == 0) {
                return false;

            }
            else{
                magLets.put(ransomNote.substring(i, i+1), magLets.get(ransomNote.substring(i, i+1)) - 1);
            }
        }

        return true;


    }

}
