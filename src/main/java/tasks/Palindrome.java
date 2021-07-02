package tasks;


public class Palindrome {


	Boolean isPalindrome(String text) {
		String reverse = "";
		int length = text.length();
		for ( int i = length - 1; i >= 0; i-- )
			reverse = reverse + text.charAt(i);
		return text.equals(reverse);
	}
}

