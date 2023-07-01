package com.in.stack07;

import java.util.Scanner;
import java.util.Stack;

public class PairwiseStringDestruction {
	public static int countRemainingWords(String[] words) {
		Stack<String> stack = new Stack<>();

		for (String word : words) {
			if (!stack.isEmpty() && stack.peek().equals(word)) {
				stack.pop(); // Destroy the similar word
			} else {
				stack.push(word); // Push the word into the stack
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of strings: ");
		int n = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter string " + (i + 1) + ": ");
			words[i] = scanner.nextLine();
		}

		int remainingWords = countRemainingWords(words);
		System.out.println("Number of words left after pairwise destruction: " + remainingWords);
	}
}
