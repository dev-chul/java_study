package com.code.sample6;

public class Util {

	public static void main(String[] args) {
		System.out.println(compareWord("hit", "hot")); // true
		System.out.println(compareWord("aba", "bab")); // false
		System.out.println(compareWord("aaa", "aab")); // true
	}
	
	public static boolean compareWord(String word1, String word2) {
		if (word1.length() != word2.length()) {
            return false;
        }

        int differentCnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }
	
}
