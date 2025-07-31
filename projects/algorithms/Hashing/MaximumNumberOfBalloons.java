package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {

    /* Task: Given a string text, you want to use the characters of text to form as many instances
    of the word "balloon" as possible. You can use each character in text at most once.
    Return the maximum number of instances that can be formed.
    */

    /* Solution: Create integer variables to keep track of the frequency of "balloon" letters in
    text while looping through it. Then, determine the limiting letter and return how many instances
    of "balloon" it can form (remember that "l" and "o" each appear in "balloon" twice).
    */

    public int maxNumberOfBalloons(String text) {

        int bCount = 0;
        int aCount = 0;
        int lCount = 0;
        int oCount = 0;
        int nCount = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == 'b'){
                bCount++;
            }
            else if (text.charAt(i) == 'a'){
                aCount++;
            }
            else if (text.charAt(i) == 'l'){
                lCount++;
            }
            else if (text.charAt(i) == 'o'){
                oCount++;
            }
            else if (text.charAt(i) == 'n'){
                nCount++;
            }
        }


        int temp = Math.min(Math.min(bCount/1, aCount/1), Math.min(lCount/2, oCount/2));

        return Math.min(temp, nCount);

    }

}
