package TreesAndGraphs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class NearestExitFromEntranceInMaze {

    /* Task: You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.')
    and walls (represented as '+'). You are also given the entrance of the maze, where entrance =
    [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
    In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a
    wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the
    entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance
    does not count as an exit. Return the number of steps in the shortest path from the entrance to
    the nearest exit, or -1 if no such path exists. */

    /* Solution: Create a queue for bfs and a discovered set. Add the entrance row and column to the
    queue. Until the queue becomes empty, add all valid, non-discovered neighbor locations (also
    keep track of steps each neighbor is from the entrance). Upon finding an exit, return the
    number of steps away it is. If the queue becomes empty before finding an exit, return -1.*/

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Integer> bfs = new LinkedList<>();
        Set<String> discovered = new HashSet<>();
        bfs.add(entrance[0]);
        bfs.add(entrance[1]);
        bfs.add(0);
        discovered.add(entrance[0] + " " + entrance[1]);
        while (!bfs.isEmpty()) {
            int x = bfs.remove();
            int y = bfs.remove();
            int dist = bfs.remove();
            if (y > 0 && maze[x][y-1] == '.' && !discovered.contains(x + " " + (y-1))){
                discovered.add(x + " " + (y-1));
                bfs.add(x);
                bfs.add(y-1);
                bfs.add(dist + 1);
                if (x == 0 || y - 1 == 0 || x == maze.length-1 || y-1 == maze[0].length - 1){
                    return dist + 1;
                }
            }
            if (x > 0 && maze[x-1][y] == '.' && !discovered.contains((x-1) + " " + y)){
                discovered.add((x-1) + " " + y);
                bfs.add(x-1);
                bfs.add(y);
                bfs.add(dist + 1);
                if (x - 1 == 0 || y == 0 || x-1 == maze.length-1 || y == maze[0].length - 1){
                    return dist + 1;
                }
            }
            if (y < maze[0].length-1 && maze[x][y+1] == '.' && !discovered.contains(x + " " + (y+1))){
                discovered.add(x + " " + (y+1));
                bfs.add(x);
                bfs.add(y+1);
                bfs.add(dist + 1);
                if (x == 0 || y + 1 == 0 || x == maze.length-1 || y+1 == maze[0].length - 1){
                    return dist + 1;
                }
            }
            if (x < maze.length-1 && maze[x+1][y] == '.' && !discovered.contains((x+1) + " " + y)){
                discovered.add((x+1) + " " + y);
                bfs.add(x+1);
                bfs.add(y);
                bfs.add(dist + 1);
                if (x + 1 == 0 || y == 0 || x+1 == maze.length-1 || y == maze[0].length - 1){
                    return dist + 1;
                }
            }
        }

        return -1;

    }

}
