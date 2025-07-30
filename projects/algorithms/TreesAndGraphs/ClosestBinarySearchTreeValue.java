package TreesAndGraphs;

public class ClosestBinarySearchTreeValue {

    /* Task: Given the root of a binary search tree and a target value, return the value in the BST
     that is closest to the target. If there are multiple answers, print the smallest. */

    /* Solution: Until reaching a null value, take a look at the root's left child if the passed val
     * argument is smaller than its val, and take a look at the root's right child if the passed val
     * argument is greater than its val. Each time, if the node's value is a lesser distance from
     * target than closestVal, update closestVal. If the node's value is the same distance from
     * target as closestVal, make closestVal the smaller of the two options. */

    public int closestValue(TreeNode root, double target) {

        int closestVal = root.val;

        while (root != null) {
            if (Math.abs(closestVal-target) > Math.abs(root.val-target)) {
                closestVal = root.val;
            }
            else if (Math.abs(closestVal-target) == Math.abs(root.val-target)) {
                closestVal = Math.min(closestVal, root.val);
            }
            if (target < root.val){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }

        return closestVal;

    }

}
