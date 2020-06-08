Hello, I cannot run unit tests on my local build, I only noticed this after creating my PalindromeRepoTest class.
Whenever I try running a test through the Intellij IDE, it cannot find my Maven dependencies.
When I try running my tests through Maven with the Spring Boot commands, it can't find my tests.
This is why you don't see any tests for PalindromeController and PalindromeService, I can't run them!
I have a feeling this has something to do with Maven, but after spending some time trying to figure out what 
configuration was off. My understanding is that Maven should be able to automatically scan tests by looking for the
keyword "Test" in the name of the Java test. This doesn't seem to be the case for me.
I've left the PalindromeRepoTest and the TestApplicationTest in there to show the work I have completed, but I don't feel
comfortable writing more without being able to run them. I hope you understand. Thank you.