package com.odx.test.service;

import com.odx.test.model.Palindrome;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService{

    /**
     * Creates the Palindrome object
     *
     * @param initialString
     * @return newly created Palindrome object
     */
    @Override
    public Palindrome createPalindrome(String initialString) {
        String longestPalindrome = findLongestPalindrome(initialString);
        return new Palindrome(initialString, longestPalindrome);
    }

    /**
     * Method will find the largest Palindrome substring in the given string.
     *
     * @param initialString The string where we want to find the largest palindrome substring.
     * @return The largest palindrome substring.
     */
    private String findLongestPalindrome(String initialString) {
        if (initialString == null || initialString.equals("")) return "";
        int start = 0, end = 0;
        /*
        Traverses through the initial string, going character by character to see if it is the center
        (or part of the center) of a palindrome. If it is, it will change the values of start and end
        which will be used to eventually return the substring containing the palindrome.
         */
        for (int i = 0; i < initialString.length(); i++) {
            //when the center of the palindrome is not a character, e.g. "otto"
            int palindromeLengthOffCenter = expandAroundCenter(initialString, i, i);
            //when the center of the palindrome is a character, e.g. "oto"
            int palindromeLengthCenter = expandAroundCenter(initialString, i, i + 1);

            int palindromeLength = Math.max(palindromeLengthCenter, palindromeLengthOffCenter);
            if (palindromeLength > end - start) {
                start = i - (palindromeLength - 1) / 2;
                end = i + palindromeLength / 2;
            }
        }
        return initialString.substring(start, end + 1);
    }

    /**
     * Finds the length of the palindrome substring inside of the given string.
     *
     * @param initialString Given the Initial String we want to find the palindrome length from
     * @param leftCharacterIndex Initial index of starting character to the left of the center.
     * @param rightCharacterIndex Initial index of the trailing character to the right of the center.
     * @return The palindrome length based off of the center of the given substring.
     */
    private int expandAroundCenter(String initialString, int leftCharacterIndex, int rightCharacterIndex) {
        int initialStringLength = initialString.length();
        while (leftCharacterIndex >= 0 && rightCharacterIndex < initialStringLength && initialString.charAt(leftCharacterIndex) == initialString.charAt(rightCharacterIndex)) {
            leftCharacterIndex--;
            rightCharacterIndex++;
        }
        return rightCharacterIndex - leftCharacterIndex - 1;
    }
}
