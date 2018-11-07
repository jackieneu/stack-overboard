# Techdegree Project 3

Stack Overboard Model Unit Tests | Written in Java

Code files: /src/main/java/com/teamtreehouse/techdegree/overboard

Test files: /src/test/com/teamtreehouse/techdegree/overboard/model

## Minimum Viable Product:
Project Description:

A friend of yours is attempting to recreate a similar website/bulletin board experience to one that happens on Stack Overflow, they are calling it Stack Overboard. There will be several “boards” which house different topic areas and skill levels.


They have started, like most projects do, by defining the model that they will be using. As they got deeper into designing the requirements they realized that there is a ton of stuff going on especially around reputation and their point system. They have decided that they better put some unit tests in place to ensure that the model is interacting the way that it is expected.


Unfortunately though, they do not have unit testing skills like you do. They’ve asked you, the unit test master, to help them knock it out.


The way things are currently defined all activities they have concerns about are coming from the User model, check the README.md file in the root for more information. They’ve done their best to ensure that all activity happens from there using some access modifier techniques.


Since you know that you are testing the Unit of Work and not necessarily the implementation you have agreed to take on the task. 


- Create a new Test Fixture for the User model in a separate but same package test directory structure. Make sure to use JUnit4. When creating your tests in IntelliJ make sure you select JUnit4 as the testing library.
- Write a test to ensure that the questioner’s reputation goes up by 5 points if their question is upvoted.
- Write a test to assert that the answerer’s reputation goes up by 10 points if their answer is upvoted.
- Write a test that proves that having an answer accepted gives the answerer a 15 point reputation boost
- Using a test, ensure that voting either up or down is not allowed on questions or answers by the original author, you know to avoid gaming the system. Ensure the proper exceptions are being thrown.
- Write a test to make sure that only the original questioner can accept an answer. Ensure the intended messaging is being sent to back to the caller.


## Extra Credit:
- Create additional objects which can be shared across tests.
- Reviewing the User.getReputation method may expose some code that is not requested to be tested in the Meets Project instructions. Write the missing test.
