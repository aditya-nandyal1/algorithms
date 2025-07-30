package TreesAndGraphs;


public class MinimumDepthOfBinaryTree {

    /* Task: Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down
    to the nearest leaf node.
    Note: A leaf is a node with no children. */

    /* Solution: Recursively find the height of a Node's left and right subtrees (starting from the
     root); each time, return the smaller of the two. */

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else if (root.right == null && root.left == null) {
            return 1;
        }
        else if (root.right == null){
            return 1 + minDepth(root.left);
        }
        else if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        else{
            return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
        }
    }


}
