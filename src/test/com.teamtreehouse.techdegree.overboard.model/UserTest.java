package com.teamtreehouse.techdegree.overboard.model;

import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class UserTest {

    private Board board;
    private User user1;
    private User user2;
    private Question question;
    private Answer answer;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        board = new Board("Unit Testing");
        user1 = board.createUser("questioner");
        user2 = board.createUser("answerer");
        question = user1.askQuestion("How do you Unit Test?");
        answer = user2.answerQuestion(question,
                "test the smallest possible part of an application");
    }

    @Test
    public void upVotingQuestionIncrementsQuestionersReputation() throws Exception{
        user2.upVote(question);

        assertEquals(5, user1.getReputation());
    }

    @Test
    public void downVotingQuestionDoesNotDecrementQuestionersReputation() throws Exception{
        int startReputation = user1.getReputation();

        user2.downVote(question);

        assertEquals(startReputation, user1.getReputation());
    }

    @Test
    public void upVotingAnswerIncrementsAnswerersReputation() throws Exception{
        user1.upVote(answer);

        assertEquals(10, user2.getReputation());
    }

    @Test
    public void downVotingAnswerDecrementsAnswerersReputation() throws Exception{
        user1.downVote(answer);

        assertEquals(-1, user2.getReputation());
    }

    @Test
    public void questionerAcceptAnswerIncrementAnswererReputation() throws Exception{
        user1.acceptAnswer(answer);

        assertEquals(15, user2.getReputation());
    }

    @Test
    public void questionerUpVotingQuestionIsNotAllowed() throws Exception{
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user1.upVote(question);
    }

    @Test
    public void questionerDownVotingQuestionIsNotAllowed() throws Exception{
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user1.downVote(question);
    }

    @Test
    public void answererUpVotingAnswerIsNotAllowed() throws Exception{
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user2.upVote(answer);
    }

    @Test
    public void answererDownVotingAnswerIsNotAllowed() throws Exception{
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user2.downVote(answer);
    }

    @Test
    public void questionerAcceptingAnswerToChangeIsAcceptedToTrue(){
        user1.acceptAnswer(answer);

        assertEquals(true, answer.isAccepted());
    }

    @Test
    public void unauthorizedQuesionerAcceptingAnswerNotAllowed(){
        thrown.expect(AnswerAcceptanceException.class);
        thrown.expectMessage("Only "+ user1.getName()
                + " can accept this answer as it is their question");

        user2.acceptAnswer(answer);
    }

}