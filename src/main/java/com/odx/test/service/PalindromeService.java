package com.odx.test.service;

import com.odx.test.model.Palindrome;

public interface PalindromeService {

    /**
     * Creates the Palindrome object
     *
     * @param initialString
     * @return newly created Palindrome object
     */
    Palindrome createPalindrome(String initialString);

}
