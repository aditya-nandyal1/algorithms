package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {

    /* Task: Given a string text, you want to use the characters of text to form as many instances
    of the word "balloon" as possible. You can use each character in text at most once.
    Return the maximum number of instances that can be formed.
    */

    /* Solution: Create a map to keep track of the frequency of letters in text. If the map does not
    contain any of the letters in "balloon", return 0. Otherwise, determine the limiting letter and
    return how many instances of "balloon" it can form (remember that "l" and "o" each appear in
    "balloon" twice).
    */

    public int maxNumberOfBalloons(String text) {

        Map<String, Integer> records = new HashMap<>();
        for (int i = 0; i < text.length(); i++){
            if(records.containsKey(text.substring(i, i+1))){
                records.put(text.substring(i, i+1), records.get(text.substring(i, i+1)) + 1);
            }
            else{
                records.put(text.substring(i, i+1), 1);
            }
        }

        if (records.get("b") == null || records.get("a") == null || records.get("l") == null || records.get("o") == null || records.get("n") == null){
            return 0;
        }

        int temp = Math.min(Math.min(records.get("b")/1, records.get("a")/1), Math.min(records.get("l")/2, records.get("o")/2));

        return Math.min(temp, records.get("n"));

    }

}
