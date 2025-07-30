package TreesAndGraphs;

public class DiameterOfBinaryTree {

    /* Task: Given the root of a binary tree, return the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    This path may or may not pass through the root. The length of a path between two nodes is
    represented by the number of edges between them. */

    /* Solution: Until reaching a null node, recursively iterate through the tree while keeping track
    * of the heights of the left and right subtrees. During each iteration, if the sum of the heights
    * of the subtrees is greater than the diameter, update the diameter. */

    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        helper(root);
        return d;
    }
    public int helper(TreeNode root)
    {
        if (root==null) {
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        d = Math.max(d,l+r);
        return 1+Math.max(l,r);
    }

}
