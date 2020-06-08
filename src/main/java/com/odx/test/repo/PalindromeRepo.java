package com.odx.test.repo;

import com.odx.test.model.Palindrome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PalindromeRepo extends JpaRepository<Palindrome, Integer> {

    /**
     * Query the repo for a Palindrome with the given Initial String.
     *
     * @param initialString The Initial String to search for.
     *
     * @return an Optional which will contain the Palindrome if one is found.
     */
    Optional<Palindrome> findByInitialString(String initialString);

}
