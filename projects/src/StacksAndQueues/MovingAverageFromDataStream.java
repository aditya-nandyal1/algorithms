package StacksAndQueues;

    /* Task: Given a stream of integers and a window size, calculate the moving average of all
    integers in the sliding window. Implement the MovingAverage class:

    - MovingAverage(int size) Initializes the object with the size of the window size.
    - double next(int val) Returns the moving average of the last size values of the stream. */

    /* Solution: Declare and initialize three instance variables, size (to a passed parameter), sum
    (to zero), and queue (to a LinkedList). In the next method, add the passed integer parameter
     to the queue and increase sum by the integer parameter. If the queue's size is smaller than
     our instance variable "size", return sum divided by the queue's size. Otherwise, remove the
     element in the front of the queue, subtract it from sum, and return sum divided by "size".*/


import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
    private int size;
    private double sum;
    private Queue<Integer> queue;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.sum = 0.0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() <= this.size) {
            return sum/queue.size();
        }
        else{
            sum -= queue.poll();
            return sum/this.size;
        }
    }
}
