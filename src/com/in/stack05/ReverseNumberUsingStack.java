package com.in.stack05;

import java.util.*;

import java.util.Stack;

public class ReverseNumberUsingStack {
	public static int reverseNumber(int number) {
		Stack<Integer> stack = new Stack<>();

		// Push each digit of the number into the stack
		while (number != 0) {
			int digit = number % 10;
			stack.push(digit);
			number /= 10;
		}

		int reversedNumber = 0;
		int placeValue = 1;

		// Pop digits from the stack to build the reversed number
		while (!stack.isEmpty()) {
			int digit = stack.pop();
			reversedNumber += digit * placeValue;
			placeValue *= 10;
		}

		return reversedNumber;
	}

	public static void main(String[] args) {
		int number = 12345;
		int reversedNumber = reverseNumber(number);
		System.out.println("Original number: " + number);
		System.out.println("Reversed number: " + reversedNumber);
	}
}
