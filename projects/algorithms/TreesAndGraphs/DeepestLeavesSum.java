package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    /* Task: Given the root of a binary tree, return the sum of values of its deepest leaves. */

    /* Solution: Perform a breadth first search on the tree (looking level by level). For each level,
    * update an integer variable to hold the new sum (replacing the last level's sum). At the end of
    * the bfs, return the sum (this should be the sum of the deepest leaves). */

    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        int rowSum = 0;

        while (!bfs.isEmpty()) {
            TreeNode temp = null;
            rowSum = 0;
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                temp = bfs.remove();
                rowSum += temp.val;
                if (temp.left != null) {
                    bfs.add(temp.left);
                }
                if (temp.right != null) {
                    bfs.add(temp.right);
                }
            }

        }

        return rowSum;

    }

}
