package TreesAndGraphs;

public class InsertIntoABinarySearchTree {

    /* Task: You are given the root node of a binary search tree (BST) and a value to insert into
    the tree. Return the root node of the BST after the insertion. It is guaranteed that the new
    value does not exist in the original BST. Notice that there may exist multiple valid ways for
    the insertion, as long as the tree remains a BST after insertion. You can return any of them. */

    /* Solution: Until reaching a null value, take a look at the root's left child if the passed val
    * argument is smaller than its val, and take a look at the root's right child if the passed val
    * argument is greater than its val. When a null value is reached, replace it with a new TreeNode
    * object with the passed integer val argument. Return the root.*/

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            return new TreeNode(val);
        }

        TreeNode toConsider = root;
        boolean cont = true;
        while (cont){
            if (toConsider.val < val){
                if (toConsider.right == null){
                    toConsider.right = new TreeNode(val);
                    cont = false;
                }
                else{
                    toConsider = toConsider.right;
                }
            }
            else{
                if (toConsider.left == null){
                    toConsider.left = new TreeNode(val);
                    cont = false;
                }
                else{
                    toConsider = toConsider.left;
                }
            }
        }
        return root;

    }

}
