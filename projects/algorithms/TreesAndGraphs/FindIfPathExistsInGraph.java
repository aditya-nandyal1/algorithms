package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class FindIfPathExistsInGraph {

    /* Task: There is a bi-directional graph with n vertices, where each vertex is labeled from 0
     to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where
     each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every
     vertex pair is connected by at most one edge, and no vertex has an edge to itself. You want to
     determine if there is a valid path that exists from vertex source to vertex destination. Given
     edges and the integers n, source, and destination, return true if there is a valid path from
     source to destination, or false otherwise. */

    /* Solution: First, iterate through the edges 2D array and create an adjacency list for each
    vertex. Then, add the source integer to a stack and perform a depth first search. During each
    iteration of the dfs, loop through all of the adjacent vertices of the vertex being considered
    and all of the vertices that have not yet been discovered. Each time we consider a vertex, we
    should check if it is the destination. If so, return true; however, if we reach the end of the
    dfs without finding a match, return false.*/

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == destination) {
                return true;
            }
            for (int neighbor : adjList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }

}
