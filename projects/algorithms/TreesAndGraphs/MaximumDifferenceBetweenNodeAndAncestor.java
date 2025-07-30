package TreesAndGraphs;

public class MaximumDifferenceBetweenNodeAndAncestor {

    /* Task: Given the root of a binary tree, find the maximum value v for which there exist
    different nodes a and b where v = |a.val - b.val| and a is an ancestor of b. A node a is an
    ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b. */

    /* Solution: Recursively check for parent/child nodes with the largest and smallest values. Upon
    * reaching a null node, return the absolute difference between the values. Use Math.max() to
    * ensure that the difference is the largest of any parent/child node pair in the tree. */

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, 0, Math.pow(10,5));
    }

    public int helper(TreeNode root, double max, double min){
        if (root == null){
            return (int)(max - min);
        }
        else{
            if (root.val > max){
                max = root.val;
            }
            if (root.val < min){
                min = root.val;
            }
            return Math.max(helper(root.left, max, min), helper(root.right, max, min));
        }
    }

}
