package TreesAndGraphs;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    /* Task: You have a graph of n nodes. You are given an integer n and an array edges where
    edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph. Return the
    number of connected components in the graph. */

    /* Solution: Create an adjacency map that matches a node to all of its neighbors. Then, iterate
    * n times. Each time, check if the node corresponding with the iteration integer has been visited
    * yet (using a boolean array to keep record). If not, add one to an integer variable titled
    * numberOfComponents and perform a dfs (that looks through all of the reachable paths from the
    * node). When each node is visited during the dfs, mark it as visited in the boolean array.
    * Finally, return numberOfComponents.*/

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> paths = new HashMap<>();
        for(int[] edge: edges) {
            paths.computeIfAbsent(edge[0], d -> new ArrayList<>()).add(edge[1]);
            paths.computeIfAbsent(edge[1], d -> new ArrayList<>()).add(edge[0]);
        }

        int numberOfComponents = 0;
        boolean[] visited = new boolean[n];
        for(int source = 0; source < n; source++) {
            if(!visited[source]) {
                dfs(source, paths, visited);
                numberOfComponents++;
            }
        }
        return numberOfComponents;
    }

    void dfs(int node, Map<Integer, List<Integer>> paths, boolean[] visited) {
        //Indicate the node has been visited.
        visited[node] = true;

        if(paths.get(node) != null) {
            List<Integer> neighbors = paths.get(node).stream().filter(n -> !visited[n]).collect(
                    Collectors.toList());
            for(int n: neighbors) {
                dfs(n, paths, visited);
            }
        }

    }

}
