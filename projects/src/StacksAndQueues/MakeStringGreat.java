package StacksAndQueues;

import java.util.Stack;

public class MakeStringGreat {

    /* Task: Given a string s of lower and upper case English letters. A good string is a string
    which doesn't have two adjacent characters s[i] and s[i + 1] where:

    - 0 <= i <= s.length - 2
    - s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

    To make the string good, you can choose two adjacent characters that make the string bad and
    remove them. You can keep doing this until the string becomes good. Return the string after
    making it good. The answer is guaranteed to be unique under the given constraints. */

    /* Solution: Create a new string and stack. Iterate through the parameter s, each time popping
    from the stack if it is not empty and the element being iterated upon is the same as
    the element on the top of the stack apart from its capitalization. Otherwise, add the element
    to the top of the stack. Afterward, while the stack is not empty, transfer its content to the
    initially created string. Return that string.
    */


    public String makeGood(String s) {
        String toReturn = "";
        Stack<String> records = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!records.isEmpty() && !records.peek().equals(s.substring(i, i+1)) && records.peek().toUpperCase().equals(s.substring(i, i+1).toUpperCase())){
                records.pop();
            }
            else{
                records.push(s.substring(i, i+1));
            }
        }
        while (!records.isEmpty()) {
            toReturn = records.pop() + toReturn;
        }
        return toReturn;
    }

}
