package com.odx.test.model;

import javax.persistence.*;

@Table(name="PALINDROME")
@Entity
public class Palindrome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private int id;

    @Column(name="INITIAL_STRING", nullable=false)
    String initialString;

    @Column(name="LONGEST_PALINDROME")
    String longestPalindrome;

    public Palindrome(String initialString, String longestPalindrome){
        this.initialString = initialString;
        this.longestPalindrome = longestPalindrome;
    }

    public long getId() {
        return id;
    }

    public String getInitialString() {
        return initialString;
    }

    public void setInitialString(String initialString) {
        this.initialString = initialString;
    }

    public String getLongestPalindrome() {
        return longestPalindrome;
    }

    public void setLongestPalindrome(String longestPalindrome) {
        this.longestPalindrome = longestPalindrome;
    }
}
