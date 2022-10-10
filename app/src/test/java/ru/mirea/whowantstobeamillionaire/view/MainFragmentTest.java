package ru.mirea.whowantstobeamillionaire.view;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MainFragmentTest {

    @Test
    public void answerIsCorrect() {
        MainFragment mainFragment = new MainFragment();

        Question question = new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Джон", "Махаон", "Десиптикон")), 1);


        assertTrue("Test not pass: 1", mainFragment.answerIsCorrect(question.getRightAnswer()));
        assertFalse("Test not pass: 2", mainFragment.answerIsCorrect(question.getWrongAnswers().get(0)));
        assertFalse("Test not pass: 3", mainFragment.answerIsCorrect(question.getWrongAnswers().get(1)));
        assertFalse("Test not pass: 4", mainFragment.answerIsCorrect(question.getWrongAnswers().get(2)));

    }

    @Test
    public void fiftyFiftyHelp() {
        MainFragment mainFragment = new MainFragment();

        Question question = new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Джон", "Махаон", "Десиптикон")), 1);
        ArrayList<String> list = question.getWrongAnswers();

        assertEquals("Махаон", mainFragment.fiftyFiftyHelp(5, question));
    }

    @Test
    public void getAudienceScore(){
        MainFragment mainFragment = new MainFragment();
        Question question = new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Джон", "Махаон", "Десиптикон")), 10);
        ArrayList<Integer> expectedDistribution = new ArrayList<>();
        expectedDistribution.add(34);
        expectedDistribution.add(50);
        expectedDistribution.add(20);
        expectedDistribution.add(20);
        ArrayList<Integer> realDistribution = mainFragment.getAudienceScore(question, 1);
        Assert.assertEquals(expectedDistribution.get(0), realDistribution.get(0));
    }

    @Test

    public void getPercentOfDifficulty() {
        Question question = new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Джон", "Махаон", "Десиптикон")), 1);

        MainFragment mainFragment = new MainFragment();
        int expectedPercentage = 93;
        int realPercentage = mainFragment.getPercentOfDifficulty(question.getDifficulty());
        Assert.assertEquals(expectedPercentage, realPercentage);
    }

    @Test
    public void Fibonachi(){
        int expectednum = 8000;
        int realnum = Fibonachi.getFibonachi(5);
        assertEquals(expectednum,realnum);


    }
}