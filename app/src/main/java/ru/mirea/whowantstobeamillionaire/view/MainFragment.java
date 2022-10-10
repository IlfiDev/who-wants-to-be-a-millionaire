package ru.mirea.whowantstobeamillionaire.view;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;



import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import ru.mirea.whowantstobeamillionaire.R;

public class MainFragment extends Fragment {

    List<Question> questions = MainActivity.question;
    Button answerA;
    Button answerB;
    Button answerC;
    Button answerD;
    TextView questionText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        questionText = view.findViewById(R.id.question_text);
        answerA = view.findViewById(R.id.answer_a_button);
        answerB = view.findViewById(R.id.answer_b_button);
        answerC = view.findViewById(R.id.answer_g_button2);
        answerD = view.findViewById(R.id.answer_v_button);
        loadQuestion(1);
        return view;
    }

//    @Test
//    public void getQuestionTest(){
//        String expectedAnswer = "rightAnswer";
//        String realAnswer = "";
//        Assert.assertEquals(expectedAnswer, realAnswer);
//    }
//
//    @Test
//    private void getFailedDialog() {
//        Boolean isFail = false;
//        Boolean getFail = null;
//        Assert.assertEquals(isFail, getFail);
//    }

    void loadQuestion(int index){
        Question question = questions.get(index);
        questionText.setText(question.getQuestion());
        List<String> answers = question.getWrongAnswers();
        answers.add(question.getRightAnswer());
        int randIndex = new Random().nextInt(4);
        answerA.setText(answers.get(randIndex));
        answers.remove(randIndex);
        randIndex = new Random().nextInt(3);
        answerB.setText(answers.get(randIndex));
        answers.remove(randIndex);
        randIndex = new Random().nextInt(2);
        answerC.setText(answers.get(randIndex));
        answers.remove(randIndex);
        answerD.setText(answers.get(0));
    }

}