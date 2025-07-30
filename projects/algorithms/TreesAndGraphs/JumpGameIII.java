package TreesAndGraphs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class JumpGameIII {

    /* Task: Given an array of non-negative integers arr, you are initially positioned at start
    index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if
    you can reach any index with value 0. Notice that you can not jump outside of the array at any
    time. */

    /* Solution: Create a visited set and a queue for bfs. Add arr[start], and start to the queue.
     Then, until the queue is empty, remove from the queue twice (the first removal should be the
     value at the index of the array currently being considered and the second one should just be
     the index). During each iteration, if the first removal equals 0, return true. Otherwise, make
     sure that i + arr[i] and i - arr[i] are valid. If they are, add their values in the array and
     indices to the queue. If the queue becomes empty before finding a value equal to zero, return
     false.*/

    public boolean canReach(int[] arr, int start) {

        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfs.offer(arr[start]);
        bfs.offer(start);
        visited.add(start);
        while (!bfs.isEmpty()) {
            int num = bfs.poll();
            int index = bfs.poll();
            if (num == 0) {
                return true;
            }
            if (index - num >= 0 && !visited.contains(index-num)) {
                visited.add(index-num);
                bfs.offer(arr[index-num]);
                bfs.offer(index-num);
            }
            if (index + num < arr.length && !visited.contains(index+num)) {
                visited.add(index+num);
                bfs.offer(arr[index+num]);
                bfs.offer(index+num);
            }
        }

        return false;

    }

}
