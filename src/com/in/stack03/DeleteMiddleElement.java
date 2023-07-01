package com.in.stack03;

import java.util.Stack;

public class DeleteMiddleElement {

	public static void deleteMiddleElement(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int middleIndex = stack.size() / 2 + 1;
		deleteMiddleUtil(stack, middleIndex);
	}

	private static void deleteMiddleUtil(Stack<Integer> stack, int current) {
		if (current == 1) {
			stack.pop();
			return;
		}

		int temp = stack.pop();
		deleteMiddleUtil(stack, current - 1);
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(3);

		System.out.println("Original Stack: " + stack);
		deleteMiddleElement(stack);
		System.out.println("Stack after deleting middle element: " + stack);
	}
}
