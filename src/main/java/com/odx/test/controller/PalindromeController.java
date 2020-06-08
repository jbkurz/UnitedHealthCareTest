package com.odx.test.controller;

import com.odx.test.model.Palindrome;
import com.odx.test.repo.PalindromeRepo;
import com.odx.test.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

    @Autowired
    private PalindromeRepo repo;

    @Autowired
    private PalindromeService service;

    /**
     * Method will take in the initialString value and creates the Palindrome object.
     *
     * @param initialString
     * @return ResponseEntity<Palindrome>, the newly created Palindrome
     */
    @PostMapping(value = "/initial_string/{initialString}")
    @ResponseBody
    public ResponseEntity<Palindrome> createPalindrome(@PathVariable String initialString){
        if(!initialString.equals(null) || !repo.findByInitialString(initialString).orElse(null).equals(null)){
            Palindrome palindrome = service.createPalindrome(initialString);
            repo.save(palindrome);
            return new ResponseEntity<>(palindrome, HttpStatus.CREATED);
        }
        //only returns this when the initial string already exists in the database
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method will take in the initialString value and returns the longest palindrome from the database
     *
     * @param initialString
     * @return ResponseEntity<String>, the longest palindrome
     */
    @GetMapping(value = "/longest_palindrome/{initialString}")
    @ResponseBody
    public ResponseEntity<String> getLongestPalindrome(@PathVariable String initialString){
        Palindrome palindrome = repo.findByInitialString(initialString).orElse(null);
        if(!initialString.equals(null) || !palindrome.equals(null)){
            String longestPalindrome = palindrome.getLongestPalindrome();
            return new ResponseEntity<>(longestPalindrome, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
