package com.in.stack08;

import java.util.Stack;

public class MaximumAbsoluteDifference {
	public static int maxAbsoluteDifference(int[] arr) {
		int n = arr.length;
		int[] nearestSmallerLeft = new int[n];
		int[] nearestSmallerRight = new int[n];
		Stack<Integer> stack = new Stack<>();

		// Find the nearest smaller element on the left side
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nearestSmallerLeft[i] = 0;
			} else {
				nearestSmallerLeft[i] = stack.peek();
			}
			stack.push(arr[i]);
		}

		stack.clear(); // Clear the stack for reuse

		// Find the nearest smaller element on the right side
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nearestSmallerRight[i] = 0;
			} else {
				nearestSmallerRight[i] = stack.peek();
			}
			stack.push(arr[i]);
		}

		int maxDifference = 0;

		// Calculate the maximum absolute difference
		for (int i = 0; i < n; i++) {
			int difference = Math.abs(nearestSmallerLeft[i] - nearestSmallerRight[i]);
			maxDifference = Math.max(maxDifference, difference);
		}

		return maxDifference;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 8, 7, 7, 9, 3 };
		int maxDifference = maxAbsoluteDifference(arr);
		System.out.println("Maximum absolute difference: " + maxDifference);
	}
}
