package TreesAndGraphs;

import java.util.Stack;

public class MaxAreaOfIsland {

    /* Task: You are given an m x n binary matrix grid. An island is a group of 1's (representing
    land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the
    grid are surrounded by water. The area of an island is the number of cells with a value 1 in
    the island. Return the maximum area of an island in grid. If there is no island, return 0.*/

    /* Solution: Create a stack and a 2D boolean array. Then, loop through the grid; when you find an
    undiscovered location with a 1, add it to the boolean array and stack. Then, begin a dfs on the
    island (keeping track of its size and discovered locations). In each iteration of the search,
    pop from the stack and add new adjacent island locations until the stack becomes empty. At the end
    of each iteration, update a variable maxSize to be either maxSize or the newly found island size
    depending on which one is bigger.*/

    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        Stack<Integer> island = new Stack<>();
        boolean[][] discovered = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !discovered[i][j]){
                    int count = 1;
                    discovered[i][j] = true;
                    island.push(i);
                    island.push(j);
                    while(!island.isEmpty()) {
                        int y = island.pop();
                        int x = island.pop();
                        if (x > 0 && grid[x-1][y] == 1 && !discovered[x-1][y]){
                            island.push(x-1);
                            island.push(y);
                            discovered[x-1][y] = true;
                            count++;
                        }
                        if (y > 0 && grid[x][y-1] == 1 && !discovered[x][y-1]){
                            island.push(x);
                            island.push(y-1);
                            discovered[x][y-1] = true;
                            count++;
                        }
                        if (y < grid[0].length-1 && grid[x][y+1] == 1 && !discovered[x][y+1]) {
                            island.push(x);
                            island.push(y+1);
                            discovered[x][y+1] = true;
                            count++;
                        }
                        if (x < grid.length-1 && grid[x+1][y] == 1 && !discovered[x+1][y]) {
                            island.push(x+1);
                            island.push(y);
                            discovered[x+1][y] = true;
                            count++;
                        }
                        maxSize = Math.max(count, maxSize);
                    }
                }
            }
        }
        return maxSize;

    }

}
