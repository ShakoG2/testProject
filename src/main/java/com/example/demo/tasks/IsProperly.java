package com.example.demo.tasks;

public class IsProperly {

	Boolean isProperly(String sequence) {
		int size = sequence.length();
		int count = 0;
		if (sequence.charAt(0) == ')') return false;
		for (int i = 0; i < size; i++) {
			if (sequence.charAt(i) == '(') {
				count++;
			} else if (sequence.charAt(i) == ')') {
				count--;
			}
		}
		return count == 0;
	}
}
