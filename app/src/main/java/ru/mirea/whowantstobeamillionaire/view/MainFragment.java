package ru.mirea.whowantstobeamillionaire.view;

import android.app.NotificationManager;
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

import com.google.android.material.dialog.MaterialAlertDialogBuilder;


import java.util.List;
import java.util.Random;

import ru.mirea.whowantstobeamillionaire.R;

public class MainFragment extends Fragment {

    List<Question> questions = new QuestionsDataBase().getQuestion();
    Button answerA, answerB, answerC, answerD, positive_button, negative_button, answer_a_button;
    TextView questionText;

    public NotificationManager notificationManager;
    private  static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";

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

    @Override
    public void onStart() {
        super.onStart();

        answer_a_button = (Button) getView().findViewById(R.id.answer_a_button);
        answer_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                failDialog();
            }
        });

    }

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

    private void failDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        builder.setBackground(getResources().getDrawable(R.drawable.dialog_shape));
        ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.fail_dialog, null);

        builder.setCancelable(false);
        builder.setView(cl);
        AlertDialog dialog = builder.show();

        positive_button = (Button) cl.findViewById(R.id.positive_button);
        negative_button = (Button) cl.findViewById(R.id.netagive_button);

        positive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Начинаем заново)", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        negative_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        
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
//        Boolean getFail = true;
//        Assert.assertEquals(isFail, getFail);
//    }

}