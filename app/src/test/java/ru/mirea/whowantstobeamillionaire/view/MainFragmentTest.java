package ru.mirea.whowantstobeamillionaire.view;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
        Question question = new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Джон", "Махаон", "Десиптикон")), 1);
        ArrayList<Double> expectedDistribution = new ArrayList<>();
        expectedDistribution.add(0.1);
        expectedDistribution.add(0.5);
        expectedDistribution.add(0.2);
        expectedDistribution.add(0.2);
        ArrayList<Double> realDistribution = mainFragment.getAudienceScore(question, 1);
        Assert.assertEquals(expectedDistribution, realDistribution);
    }

    @Test
    public void getPercentageOfNumber(){
        Question question = new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Джон", "Махаон", "Десиптикон")), 15);

        MainFragment mainFragment = new MainFragment();
        int expectedPercentage = 66;
        int realPercentage = mainFragment.getPercentageOfDifficulty(question);
        Assert.assertEquals(expectedPercentage, realPercentage);
    }
}