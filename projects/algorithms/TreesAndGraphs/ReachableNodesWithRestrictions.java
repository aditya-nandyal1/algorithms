package TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;


public class ReachableNodesWithRestrictions {

    /* Task: There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges. You
    are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there
    is an edge between nodes ai and bi in the tree. You are also given an integer array restricted
    which represents restricted nodes. Return the maximum number of nodes you can reach from node 0
    without visiting a restricted node. Note that node 0 will not be a restricted node.*/

    /* Solution: First, create an adjacency map with integer node representations as keys and lists
    of nodes' neighbors as values. Then, create a restricted set using the restricted array parameter
    (sets have a contains method that works in O(1)). Next, initialize a discovered set. Afterward,
    create a stack to use for dfs. First, add 0 to the stack. Then, pop a value from the stack, add
    the popped value's undiscovered and unrestricted neighbors to the stack (keeping track of the
    number of reachable nodes using a variable called count), and continue with this
    pattern until the stack is empty. Finally, return count. */

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (adjList.get(edges[i][0]) == null){
                Set<Integer> toAdd = new HashSet<>();
                toAdd.add(edges[i][1]);
                adjList.put(edges[i][0], toAdd);
            }
            else{
                Set<Integer> toAdd = adjList.get(edges[i][0]);
                toAdd.add(edges[i][1]);
                adjList.put(edges[i][0], toAdd);
            }
            if (adjList.get(edges[i][1]) == null){
                Set<Integer> toAdd = new HashSet<>();
                toAdd.add(edges[i][0]);
                adjList.put(edges[i][1], toAdd);
            }
            else{
                Set<Integer> toAdd = adjList.get(edges[i][1]);
                toAdd.add(edges[i][0]);
                adjList.put(edges[i][1], toAdd);
            }
        }

        Set<Integer> restr = new HashSet<>();
        for (int i = 0; i < restricted.length; i++){
            restr.add(restricted[i]);
        }

        Set<Integer> disc = new HashSet<>();

        Stack<Integer> dfs = new Stack<>();
        dfs.push(0);
        disc.add(0);
        int count = 1;
        while(!dfs.isEmpty()){
            int temp = dfs.pop();
            for (int adj: adjList.get(temp)){
                if (!restr.contains(adj) && !disc.contains(adj)){
                    disc.add(adj);
                    dfs.push(adj);
                    count++;
                }
            }
        }

        return count;


    }

}
