package com.odx.test.application;

import com.odx.test.repo.PalindromeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/appTest.yml")
@ContextConfiguration(classes = {PalindromeRepo.class})
@EnableJpaRepositories("com.odx.text.repo")
@EntityScan("com.odx.text.model")
public class TestApplicationTest {
    @Test
    public void contextLoads(){}
}
