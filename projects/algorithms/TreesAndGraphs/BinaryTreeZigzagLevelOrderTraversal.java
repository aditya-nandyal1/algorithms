package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    /* Task: Given the root of a binary tree, return the zigzag level order traversal of its
    nodes' values. (i.e., from left to right, then right to left for the next level and alternate
    between). */

    /* Solution: Perform a bfs on the binary tree in order to iterate level-by-level, keeping track
    of nodes using both a stack and a queue. For odd levels, only add new nodes to the bfs queue
    and only add stack removals to the return list. For even levels, add new nodes to both the stack
    and the queue and only add queue removals to the return list. Finally, return the return list.*/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> toReturn = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        Stack<TreeNode> helper = new Stack<>();
        helper.push(root);
        bfs.add(root);
        TreeNode temp = null;
        TreeNode tempTwo = null;
        int count = 0;
        while (!bfs.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                temp = bfs.remove();
                if (count % 2 == 1){
                    tempTwo = helper.pop();
                }
                if (temp.left != null){
                    bfs.add(temp.left);
                    if (count % 2 == 0){
                        helper.add(temp.left);
                    }
                }
                if (temp.right != null){
                    bfs.add(temp.right);
                    if (count % 2 == 0) {
                        helper.add(temp.right);
                    }
                }
                if (count % 2 == 1){
                    level.add(tempTwo.val);
                }
                else{
                    level.add(temp.val);
                }
            }
            toReturn.add(level);
            count++;
        }
        return toReturn;
    }

}
