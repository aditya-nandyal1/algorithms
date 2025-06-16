package StacksAndQueues;

import java.util.Stack;
import java.util.StringTokenizer;

public class SimplifyPath {

    /* Task: You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

    The rules of a Unix-style file system are as follows:

    A single period '.' represents the current directory.
    A double period '..' represents the previous/parent directory.
    Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
    The simplified canonical path should follow these rules:

    The path must start with a single slash '/'.
    Directories within the path must be separated by exactly one slash '/'.
    The path must not end with a slash '/', unless it is the root directory.
    The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
    Return the simplified canonical path. */

    /* Solution: Split the passed String argument by "/" and create a stack. Iterate through the
    tokenized String. Upon coming across "..", pop from the stack (if possible). Upon coming across
    anything else except for "" and ".", add it to the stack. Afterward, pop from the stack until it's
    empty and transfer its contents into a new String (placing a backslash between elements). If the
    new String is of length 1, return it. Otherwise, make sure to get rid of the ending backslash and
    then return it.
    */


    public String simplifyPath(String path) {
        StringTokenizer pathTokens = new StringTokenizer(path, "/");
        Stack<String> simplePath = new Stack<>();
        while (pathTokens.hasMoreTokens()) {
            String token = pathTokens.nextToken();
            if (token.equals("..")){
                if (!simplePath.isEmpty()){
                    simplePath.pop();
                }
            }
            else if (!token.equals(".") && !token.equals("")){
                simplePath.push(token);
            }
        }

        String toReturn = "/";
        while (!simplePath.isEmpty()) {
            toReturn = "/" + simplePath.pop() + toReturn;
        }

        if (toReturn.length() == 1) {
            return toReturn;
        }
        else return toReturn.substring(0, toReturn.length()-1);
    }

}
