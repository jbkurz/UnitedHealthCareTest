package com.odx.test.repo;

import com.odx.test.model.Palindrome;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Palindrome.class)
@TestPropertySource("/appTest.yml")
@EnableAutoConfiguration
@EnableJpaRepositories("com.odx.test.repo")
@EntityScan("com.odx.test.model")
public class PalindromeRepoTest {

    @Autowired
    private PalindromeRepo repo;

    @Before
    public void setup(){
        repo.deleteAll();
    }

    @Test
    public void testEmpty(){
        assertRepoSize(0L);
    }

    @Test
    public void testLoad(){
        Palindrome palindrome1 = new Palindrome("test1", "t");
        Palindrome palindrome2 = new Palindrome("test2", "t");

        repo.save(palindrome1);
        repo.save(palindrome2);

        assertRepoSize(2);
    }

    @Test
    public void testFindByInitialString(){
        Palindrome palindrome = new Palindrome("test", "t");
        repo.save(palindrome);

        String palindromeInitialString = palindrome.getInitialString();
        assertNotNull(palindromeInitialString);

        Palindrome result = repo.findByInitialString(palindromeInitialString).orElse(null);
        assertNotNull(result);

        assertEquals(palindromeInitialString, result.getInitialString());
    }

    /**
     *
     * ---------------------Utility Methods---------------------
     *
     */

    private <T> Stream<T> toStream (Iterable<T> iterable){
        return (StreamSupport.stream(iterable.spliterator(), false));
    }


    private void assertRepoSize(final long size){
        List<Palindrome> allInRepo = toStream(repo.findAll()).collect(Collectors.toList());
        assertEquals(size, allInRepo.size());
    }


}
