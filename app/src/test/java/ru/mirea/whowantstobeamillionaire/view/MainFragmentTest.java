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

}