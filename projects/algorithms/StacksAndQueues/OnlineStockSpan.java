package StacksAndQueues;

   /* Task: Design an algorithm that collects daily price quotes for some stock and returns the span
   of that stock's price for the current day. The span of the stock's price in one day is the
   maximum number of consecutive days (starting from that day and going backward) for which the
   stock price was less than or equal to the price of that day. */

    /* Solution: Create a stack and a map as instance variables for the class (handle assignment
    inside the constructor). Inside the next() method, create a variable to keep track of the longest
    span, and initialize it to 1. While the stack is not empty and the integer on the top of the
    stack is less than or equal to price, pop the top element from the stack and add its corresponding
    value in the map to longestSpan. Then, push price onto the top of the stack and create a new
    entry in the map with price as a key and its longestSpan as a value. Finally, return longestValue.
     */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OnlineStockSpan {

    private Stack<Integer> stockStack;
    private Map<Integer, Integer> stockMap;

    public OnlineStockSpan() {
        stockStack = new Stack<>();
        stockMap = new HashMap<>();
    }

    public int next(int price) {
        int longestSpan = 1;
        while (!stockStack.isEmpty() && price >= stockStack.peek()){
            longestSpan += stockMap.get(stockStack.pop());
        }
        stockStack.push(price);
        stockMap.put(price, longestSpan);
        return longestSpan;
    }
}
