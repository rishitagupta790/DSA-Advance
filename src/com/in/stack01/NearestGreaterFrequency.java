package com.in.stack01;

import java.util.*;

public class NearestGreaterFrequency {

	public static int[] findNearestGreaterFrequency(int[] arr) {
		int[] result = new int[arr.length];
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		// Calculate the frequency of each element in the array
		for (int num : arr) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// Traverse the array from left to right
		for (int i = 0; i < arr.length; i++) {
			int currentFrequency = frequencyMap.get(arr[i]);
			result[i] = -1; // Default value if no element with greater frequency is found

			while (!stack.isEmpty() && frequencyMap.get(arr[stack.peek()]) <= currentFrequency) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				result[i] = arr[stack.peek()];
			}

			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 4, 2, 1 };

		int[] nearestGreater = findNearestGreaterFrequency(arr);
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Nearest Greater Elements: " + Arrays.toString(nearestGreater));
	}
}
