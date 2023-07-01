package com.in.stack06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsInQueue {
	public static void reverseKElements(Queue<Integer> queue, int k) {
		if (queue.isEmpty() || k <= 0 || k > queue.size()) {
			return;
		}

		Stack<Integer> stack = new Stack<>();

		// Push the first k elements into the stack
		for (int i = 0; i < k; i++) {
			stack.push(queue.poll());
		}

		// Enqueue the elements from the stack back into the queue
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		// Move the remaining (n - k) elements to the back of the queue
		for (int i = 0; i < queue.size() - k; i++) {
			queue.add(queue.poll());
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

		int k = 3;

		System.out.println("Original Queue: " + queue);
		reverseKElements(queue, k);
		System.out.println("Queue after reversing the first " + k + " elements: " + queue);
	}
}
