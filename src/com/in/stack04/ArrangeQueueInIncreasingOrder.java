package com.in.stack04;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrangeQueueInIncreasingOrder {

    public static boolean checkIncreasingOrder(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> outputQueue = new LinkedList<>();
        int expected = 1;

        while (!queue.isEmpty()) {
            if (queue.peek() == expected) {
                outputQueue.add(queue.poll());
                expected++;
            } else if (!stack.isEmpty() && stack.peek() == expected) {
                outputQueue.add(stack.pop());
                expected++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == expected) {
                outputQueue.add(stack.pop());
                expected++;
            } else {
                return false;
            }
        }

        return queue.isEmpty() && stack.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(5);

        boolean canArrange = checkIncreasingOrder(queue);
        System.out.println("Can the elements be arranged in increasing order? " + canArrange);
    }
}
